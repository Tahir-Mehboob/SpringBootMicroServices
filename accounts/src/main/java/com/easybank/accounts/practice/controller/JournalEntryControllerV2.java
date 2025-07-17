package com.easybank.accounts.practice.controller;


import com.easybank.accounts.practice.entity.JournalEnttiyV2;
import com.easybank.accounts.practice.entity.User;
import com.easybank.accounts.practice.services.JournalEntryService;
import com.easybank.accounts.practice.services.UserService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal_entries_v2")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    /*@GetMapping
    public List<JournalEnttiyV2> getAllJournalEntries() {
        return journalEntryService.getAll();
    }*/

    /*@GetMapping
    public ResponseEntity<?> getAllJournalEntries() {
        List<JournalEnttiyV2> all = journalEntryService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);//journalEntryService.getAll().orElse(null>
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findUserByUserName(userName);
        List<JournalEnttiyV2> all = user.getJournalEntries();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);//journalEntryService.getAll().orElse(null>
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   /* @GetMapping("id/{myId}")
    public JournalEnttiyV2 getJournalEntityById(@PathVariable ObjectId myId) {
        System.out.println("Request hit ... "+myId);
        return journalEntryService.findJournalEntryByID(myId).orElse(null);
    }*/

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEnttiyV2> getJournalEntityById(@PathVariable ObjectId myId) {
        Optional<JournalEnttiyV2> journalEnttiyV2 = journalEntryService.findJournalEntryByID(myId);
        if(journalEnttiyV2.isPresent()) {
            return new ResponseEntity<>(journalEnttiyV2.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   /* @PostMapping
    public boolean creatEntry(@RequestBody JournalEnttiyV2 journalEnttiy) {
        journalEnttiy.setDate(LocalDateTime.now());
         journalEntryService.addJournalEntry(journalEnttiy);
         return true;
    }*/

    @PostMapping
    public ResponseEntity<JournalEnttiyV2> creatEntry(@RequestBody JournalEnttiyV2 journalEnttiy,@PathVariable String userName) {
       try {
           User user = userService.findUserByUserName(userName);
           journalEnttiy.setDate(LocalDateTime.now());
           journalEntryService.addJournalEntry(journalEnttiy);
           return new ResponseEntity<>(journalEnttiy, HttpStatus.CREATED);
       }catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    // write delete endpoints here
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId) {
        journalEntryService.deleteJournalEntryById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // write update endpoints here
    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEnttiyV2 newJournalEnttiy) {
        JournalEnttiyV2 oldJournalEnttiyV2 = journalEntryService.findJournalEntryByID(myId).orElse(null);
        if(oldJournalEnttiyV2 != null) {
            oldJournalEnttiyV2.setTitle(newJournalEnttiy.getTitle() != null && !newJournalEnttiy.getTitle().equals("")  ? newJournalEnttiy.getTitle() : oldJournalEnttiyV2.getTitle());
            oldJournalEnttiyV2.setContent(newJournalEnttiy.getContent() != null && !newJournalEnttiy.getContent().equals("") ? newJournalEnttiy.getContent() : oldJournalEnttiyV2.getContent());
            journalEntryService.addJournalEntry(oldJournalEnttiyV2);
            return new ResponseEntity<>(oldJournalEnttiyV2, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
