package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.Accounts.Checking;
import com.ironhack.FinalProject.models.Accounts.Savings;
import com.ironhack.FinalProject.models.DTO.TransactionDTO;
import com.ironhack.FinalProject.models.Movements.Transaction;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.repositories.AccountsRepositories.AccountRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.SavingsRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.AccountHoldersRepository;
import com.ironhack.FinalProject.repositories.TransactionsRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountHoldersService {
    @Autowired
    AccountHoldersRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SavingsRepository savingsRepository;


    public AccountHolders addAccountHolder(AccountHolders accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    public Account getAccount(Long id){
        if(accountHolderRepository.findPrimaryOwnerAccountById(id).isPresent()){
            return accountHolderRepository.findPrimaryOwnerAccountById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        }
        else
            return accountHolderRepository.findSecondaryOwnerAccountById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
    }

    public Transaction transfer(TransactionDTO transactionDTO){

        Account originAccount=accountRepository.findById(transactionDTO.getOriginAccountId()).get();
        Account destinyAccount=accountRepository.findById(transactionDTO.getDestinyAccountId()).get();
        if(originAccount.getBalance().compareTo(transactionDTO.getAmount())>0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Not enough founds");
        if(transactionDTO.getRecipientName().equals(destinyAccount.getPrimaryOwner().getName()) || transactionDTO.getRecipientName().equals(destinyAccount.getSecondaryOwner().getName()) ) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"not enough founds");

        originAccount.setBalance(originAccount.getBalance().subtract(transactionDTO.getAmount()));
        destinyAccount.setBalance(destinyAccount.getBalance().add(transactionDTO.getAmount()));

        //Aplicamos el penaltyFee en el caso de que la cuenta tenga menos saldo que el minimumBalance:
        if(originAccount instanceof Checking){
            Checking checking = (Checking) originAccount;
            if(checking.getBalance().compareTo(checking.getMinimumBalance()) > 0) {
                checking.setBalance(checking.getBalance().subtract(checking.getPenaltyFee()));
                accountRepository.save(checking);
            }
        else if (originAccount instanceof Savings) {
            Savings savings= (Savings) originAccount;
            if(savings.getBalance().compareTo(savings.getMinimumBalance()) > 0){
                    savings.setBalance(savings.getBalance().subtract(savings.getPenaltyFee()));
                    savingsRepository.save(savings);
                    }
            }
        }
        accountRepository.save(originAccount);
        accountRepository.save(destinyAccount);
        Transaction transaction=new Transaction(transactionDTO.getAmount(),destinyAccount,originAccount);

        return transactionRepository.save(transaction);
    }
}
