package com.sahani.banking.service;

import com.sahani.banking.dto.AccountDto;
import com.sahani.banking.model.Account;

import java.util.List;

public interface AccountService {
    public AccountDto createAccount(AccountDto accountDto);

    public AccountDto getAccountById(Long id);

    public List<AccountDto> geAllAccount();
    public AccountDto depositeAccount(Long id, double balance);
    public AccountDto withdrawAmount(Long id, double balance);
}
