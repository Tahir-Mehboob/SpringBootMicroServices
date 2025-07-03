package com.easybank.accounts.practice.repository;

import com.easybank.accounts.practice.entity.JournalEnttiyV2;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEnttiyV2, ObjectId> {
}
