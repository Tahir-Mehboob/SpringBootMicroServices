package com.easybank.accounts.practice.controller;

import com.easybank.accounts.practice.entity.JournalEnttiy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("journal")
public class JournalEntryControllerV2 {

    @GetMapping
    public List<JournalEnttiy> getAllJournalEntries() {
        return null;
    }

    @GetMapping("id/{myId}")
    public JournalEnttiy getJournalEntity(@PathVariable Long myId) {
        System.out.println("Request hit ... "+myId);
        return null;
    }

    @PostMapping
    public boolean creatEntry(@RequestBody JournalEnttiy journalEnttiy) {
        return true;
    }
    // write delete endpoints here

    @DeleteMapping("id/{myId}")
    public boolean deleteEntry(@PathVariable Long myId) {
        return null;
    }
    // write update endpoints here
    @PutMapping("id/{myId}")
    public JournalEnttiy updateEntry(@PathVariable Long myId, @RequestBody JournalEnttiy journalEnttiy) {
        return null;
    }
}
