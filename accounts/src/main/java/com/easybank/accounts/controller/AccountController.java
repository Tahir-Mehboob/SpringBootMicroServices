package com.easybank.accounts.controller;

import com.easybank.accounts.dto.CustomerDto;
import com.easybank.accounts.dto.ResponseDto;
import com.easybank.accounts.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path="api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    int requestCount = 0;

  /*  @GetMapping("sayHello")
    public String sayHello() {

        System.out.println("request hit ........ "+ (++requestCount));
        return "Hello Spring Boot";
    }*/

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto())
    }

}
