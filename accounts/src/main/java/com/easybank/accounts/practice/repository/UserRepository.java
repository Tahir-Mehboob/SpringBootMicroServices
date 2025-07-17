package com.easybank.accounts.practice.repository;

import com.easybank.accounts.practice.entity.JournalEnttiyV2;
import com.easybank.accounts.practice.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
}
