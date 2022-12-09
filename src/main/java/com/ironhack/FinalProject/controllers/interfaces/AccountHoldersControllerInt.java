package com.ironhack.FinalProject.controllers.interfaces;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.DTO.TransactionDTO;
import com.ironhack.FinalProject.models.Movements.Transaction;

import java.math.BigDecimal;

public interface AccountHoldersControllerInt {
    Account findAccountById(Long ownerId, Long accountId);
    BigDecimal findAccountBalance(Long ownerId, Long accountId);
    Transaction makeTransaction(TransactionDTO transactionDTO);
}
