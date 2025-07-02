package com.easybank.accounts.practice.controller;

import com.easybank.accounts.practice.entity.JournalEnttiy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("_journal")
public class JournalEntryController {

    // create a map to store all the journal entries like a database/ table
    private Map<Long, JournalEnttiy> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEnttiy> getAllJournalEntries() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("id/{myId}")
    public JournalEnttiy getJournalEntity(@PathVariable Long myId) {
        System.out.println("Request hit ... "+myId);
        return journalEntries.get(myId);
    }

    @PostMapping
    public boolean creatEntry(@RequestBody JournalEnttiy journalEnttiy) {
        journalEntries.put(journalEnttiy.getId(), journalEnttiy);
        return true;
    }
    // write delete endpoints here

    @DeleteMapping("id/{myId}")
    public boolean deleteEntry(@PathVariable Long myId) {
        return journalEntries.remove(myId) != null;
    }
    // write update endpoints here
    @PutMapping("id/{myId}")
    public JournalEnttiy updateEntry(@PathVariable Long myId, @RequestBody JournalEnttiy journalEnttiy) {
        journalEntries.put(myId, journalEnttiy);
        return journalEnttiy;
    }
}
