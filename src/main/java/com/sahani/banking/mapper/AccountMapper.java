package com.sahani.banking.mapper;

import com.sahani.banking.dto.AccountDto;
import com.sahani.banking.model.Account;

public class AccountMapper {
    public  static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolder(),
                accountDto.getBalance()

        );
    }
    public  static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
               account.getId(),
               account.getAccountHolder(),
               account.getBalance()
       );
    }

}
