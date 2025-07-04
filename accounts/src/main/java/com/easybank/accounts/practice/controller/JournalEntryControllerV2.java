package com.easybank.accounts.practice.controller;


import com.easybank.accounts.practice.entity.JournalEnttiyV2;
import com.easybank.accounts.practice.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEnttiyV2> getAllJournalEntries() {
        return journalEntryService.getAll();
    }

    @GetMapping("id/{myId}")
    public JournalEnttiyV2 getJournalEntityById(@PathVariable ObjectId myId) {
        System.out.println("Request hit ... "+myId);
        return journalEntryService.findJournalEntryByID(myId).orElse(null);
    }

    @PostMapping
    public boolean creatEntry(@RequestBody JournalEnttiyV2 journalEnttiy) {
        journalEnttiy.setDate(LocalDateTime.now());
         journalEntryService.addJournalEntry(journalEnttiy);
         return true;
    }

    // write delete endpoints here
    @DeleteMapping("id/{myId}")
    public boolean deleteEntry(@PathVariable ObjectId myId) {
        return journalEntryService.deleteJournalEntryById(myId);
    }
    // write update endpoints here
    @PutMapping("id/{myId}")
    public JournalEnttiyV2 updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEnttiyV2 newJournalEnttiy) {
        JournalEnttiyV2 oldJournalEnttiyV2 = journalEntryService.findJournalEntryByID(myId).orElse(null);
        if(oldJournalEnttiyV2 != null) {
            oldJournalEnttiyV2.setTitle(newJournalEnttiy.getTitle() != null && newJournalEnttiy.getTitle().equals("")  ? newJournalEnttiy.getTitle() : oldJournalEnttiyV2.getTitle());
            oldJournalEnttiyV2.setContent(newJournalEnttiy.getContent() != null && newJournalEnttiy.getContent().equals("") ? newJournalEnttiy.getContent() : oldJournalEnttiyV2.getContent());
            journalEntryService.addJournalEntry(oldJournalEnttiyV2);

        }
        return oldJournalEnttiyV2;

    }
}
