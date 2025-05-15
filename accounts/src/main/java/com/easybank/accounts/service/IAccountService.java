package com.easybank.accounts.service;

import com.easybank.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * create an account for a customer
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
}
