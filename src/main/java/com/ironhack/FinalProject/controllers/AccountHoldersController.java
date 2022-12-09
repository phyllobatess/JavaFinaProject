package com.ironhack.FinalProject.controllers;


import com.ironhack.FinalProject.controllers.interfaces.AccountHoldersControllerInt;
import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.DTO.TransactionDTO;
import com.ironhack.FinalProject.models.Movements.Transaction;
import com.ironhack.FinalProject.services.AccountHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountHoldersController implements AccountHoldersControllerInt {

    @Autowired
    AccountHoldersService accountHoldersService;

    @GetMapping("/{accountId}/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public Account findAccountById(@PathVariable Long accountId, Long ownerId) {
        return accountHoldersService.getAccount( accountId, ownerId);
    }

    @GetMapping("/balance/{accountId}/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal findAccountBalance(@PathVariable Long accountId, Long ownerId) {
        return accountHoldersService.getAccountBalance(accountId, ownerId);
    }

    @PostMapping("/transfer-money")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction makeTransaction(@RequestBody TransactionDTO transactionDTO){
        return accountHoldersService.transfer(transactionDTO);
    }
}
