package com.easybank.accounts.practice.controller;

import com.easybank.accounts.practice.dto.UserDTO;
import jakarta.transaction.UserTransaction;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class UserController {

    @Autowired
    private UserDTO userdto;
    /**
     * Handles HTTP GET requests for the "/user" endpoint.
     *
     * @return a String response to be sent back to the client.
     */
    @GetMapping("/user")
    public ResponseEntity<UserDTO> user(){

      /*  user.setName("Tahir Mehboob");
        user.setPassword("1234");
        user.setEmail("TahirMehboob106@gmail.com");*/

        return ResponseEntity.ok(userdto);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userdto){
        // If validation passes, proceed
        System.out.println("Request Hits............");
        System.out.println("");
        return ResponseEntity.ok(userdto);
    }

}
