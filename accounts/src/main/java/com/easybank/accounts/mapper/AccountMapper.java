package com.easybank.accounts.mapper;

import com.easybank.accounts.dto.AccountDto;
import com.easybank.accounts.entity.Accounts;

public class AccountMapper {

    public static AccountDto mapToAccountsDto(Accounts accounts,AccountDto accountDto){
            accountDto.setAccountNumber(accounts.getAccountNumber());
            accountDto.setAccountType(accounts.getAccountType());
            accountDto.setBranchAddress(accounts.getBranchAddress());

            return accountDto;
    }

    public static Accounts mapToAccounts(Accounts accounts,AccountDto accountDto){

            accounts.setAccountNumber(accountDto.getAccountNumber());
            accounts.setAccountType(accountDto.getAccountType());
            accounts.setBranchAddress(accountDto.getBranchAddress());

            return accounts;
    }

}
