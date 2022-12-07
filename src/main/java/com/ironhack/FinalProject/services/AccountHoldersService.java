package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.controllers.interfaces.AccountHoldersControllerInt;
import com.ironhack.FinalProject.repositories.UserRepositories.AccountHoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountHoldersService implements AccountHoldersControllerInt {
    @Autowired
    AccountHoldersRepository accountHoldersRepository;
}
