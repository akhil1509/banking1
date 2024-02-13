package com.sahani.banking.service;

import com.sahani.banking.dto.AccountDto;
import com.sahani.banking.mapper.AccountMapper;
import com.sahani.banking.model.Account;
import com.sahani.banking.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    public AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find account"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> geAllAccount() {
        List<Account> all = accountRepository.findAll();
       return all.stream().map((AccountMapper::mapToAccountDto)).collect(Collectors.toList());

    }


    @Override
    public AccountDto depositeAccount(Long id, double balance) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find account"));
        double v = account.getBalance() + balance;
        account.setBalance(v);
        Account save = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(save);
    }

    @Override
    public AccountDto withdrawAmount(Long id, double balance) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find account"));
        if ((account.getBalance()<balance))
        {
            throw  new RuntimeException("insufficient balance");
        }
        double v = account.getBalance() - balance;
        account.setBalance(v);
        Account newBalance = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(newBalance);
    }


}
