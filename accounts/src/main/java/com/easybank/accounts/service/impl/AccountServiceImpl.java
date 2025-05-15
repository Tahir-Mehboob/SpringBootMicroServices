package com.easybank.accounts.service.impl;

import com.easybank.accounts.dto.CustomerDto;
import com.easybank.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {


    /**
     * create an account for a customer
     *
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
