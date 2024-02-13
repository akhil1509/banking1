package com.sahani.banking.controller;

import com.sahani.banking.dto.AccountDto;
import com.sahani.banking.model.Account;
import com.sahani.banking.service.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class AccountController {
    public AccountServiceImpl accountServiceImpl;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @PostMapping("/post")
   public ResponseEntity<AccountDto> addAccount( @RequestBody AccountDto accountDto){
        return  new ResponseEntity<>(accountServiceImpl.createAccount(accountDto), HttpStatus.CREATED);

   }
   @GetMapping("/{id}")
   public  ResponseEntity<AccountDto> getAccountById(@PathVariable("id")  Long id){
       AccountDto accountById = accountServiceImpl.getAccountById(id);
       return new ResponseEntity<>(accountById, HttpStatus.OK);
   }
   @PutMapping("/{id}/deposite")
   public ResponseEntity<AccountDto> deposite( @PathVariable Long id,  @RequestBody Map<String, Double> request){
       AccountDto balance = accountServiceImpl.depositeAccount(id, request.get("balance"));
       return new ResponseEntity<>(balance, HttpStatus.ACCEPTED);
   }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>  withdrawAmount( @PathVariable Long id,  @RequestBody Map<String, Double> request){
        AccountDto balance = accountServiceImpl. withdrawAmount(id, request.get("balance"));
        return new ResponseEntity<>(balance, HttpStatus.ACCEPTED);
    }

    @GetMapping("/allAccount")
    public ResponseEntity<List<AccountDto>> geAllAccounts(){
        List<AccountDto> accountDtos = accountServiceImpl.geAllAccount();
        return new ResponseEntity<>(accountDtos, HttpStatus.FOUND);
    }
}
