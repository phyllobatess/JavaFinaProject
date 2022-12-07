package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.controllers.interfaces.AccountHoldersControllerInt;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.repositories.UserRepositories.AccountHoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountHoldersService implements AccountHoldersControllerInt {
    @Autowired
    AccountHoldersRepository accountHoldersRepository;

    AccountHoldersRepository accountHolderRepository;
    public AccountHolders addAccountHolder(AccountHolders accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }
}
