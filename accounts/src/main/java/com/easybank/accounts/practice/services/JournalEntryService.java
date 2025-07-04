package com.easybank.accounts.practice.services;


import com.easybank.accounts.practice.entity.JournalEnttiyV2;
import com.easybank.accounts.practice.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    // best practice for controller layer call service layer
    // controller -> service -> repository

    //Step1:
        // adding JournalEntryRepository as a dependency in JournalEntryService
        //JournalEntryService depends on JournalEntryRepository
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void addJournalEntry(JournalEnttiyV2 journalEnttiy) {
        journalEntryRepository.save(journalEnttiy);
    }

    public List<JournalEnttiyV2> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEnttiyV2> findJournalEntryByID(ObjectId id) {
        return journalEntryRepository.findById(id);
    }
    public boolean deleteJournalEntryById(ObjectId id) {
        journalEntryRepository.deleteById(id);
        return true;
    }
}

