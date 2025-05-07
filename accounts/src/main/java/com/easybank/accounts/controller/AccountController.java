package com.easybank.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    int requestCount = 0;

    @GetMapping("sayHello")
    public String sayHello() {

        System.out.println("request hit ........ "+ (++requestCount));
        return "Hello Spring Boot";
    }

}
