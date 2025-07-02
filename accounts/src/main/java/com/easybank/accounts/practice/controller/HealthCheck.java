package com.easybank.accounts.practice.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    // return a simple string to indicate the service is up and running
        @org.springframework.web.bind.annotation.GetMapping("/health-check")
    public String healthCheck() {
        return "Health Check Pass OK .... ";
    }
}
