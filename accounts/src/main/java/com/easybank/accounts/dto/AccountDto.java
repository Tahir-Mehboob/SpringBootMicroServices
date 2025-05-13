package com.easybank.accounts.dto;

import lombok.Data;

/**
 * below @Data annotation is used to generate getter and setter methods automatically by Lombok
 */

@Data
public class AccountDto {

    private Long accountNumber;
    private String accountType;
    private Double branchAddress;

}
