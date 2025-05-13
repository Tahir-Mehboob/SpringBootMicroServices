package com.easybank.accounts.dto;

import lombok.Data;

/**
 * below @Data annotation is used to generate getter and setter methods automatically by Lombok
 */

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String mobileNumber;

}
