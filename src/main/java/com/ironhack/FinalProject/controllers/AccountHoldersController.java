package com.ironhack.FinalProject.controllers;


import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.services.AccountHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHoldersController {

    @Autowired
    AccountHoldersService accountHoldersService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findAccountById(@PathVariable Long id){
        return accountHoldersService.getAccount(id);
    }
}
