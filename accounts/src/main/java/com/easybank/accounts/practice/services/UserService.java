package com.easybank.accounts.practice.services;


import com.easybank.accounts.practice.entity.User;
import com.easybank.accounts.practice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    // best practice for controller layer call service layer
    // controller -> service -> repository

    //Step1:
        // adding JournalEntryRepository as a dependency in JournalEntryService
        //JournalEntryService depends on JournalEntryRepository
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {

        return userRepository.findAll();
    }

    public Optional<User> findUserByID(ObjectId id) {
        return userRepository.findById(id);
    }
    public boolean deleteUserById(ObjectId id) {
        userRepository.deleteById(id);
        return true;
    }
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}

