package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.controllers.interfaces.AdminsControllerInt;
import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.Accounts.Checking;
import com.ironhack.FinalProject.models.Accounts.StudentChecking;
import com.ironhack.FinalProject.models.DTO.AccountDto;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.models.Users.Admins;
import com.ironhack.FinalProject.repositories.AccountsRepositories.CheckingRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.CreditCardRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.SavingsRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.StudentCheckingRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.AccountHoldersRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.AdminsRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;


@Service
public class AdminsService implements AdminsControllerInt   {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    @Autowired
    AccountHoldersRepository accountHoldersRepository;

    @Autowired
    AdminsRepository adminsRepository;

    @Autowired
    ThirdPartyRepository thirdPartyRepository;


    public Admins addAdmin(Admins admin) {
        return adminsRepository.save(admin);
    }

    public Account addChecking(AccountDto accountDto) {
        AccountHolders primaryOwner = accountHoldersRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Object Account Holder does not exist"));

        LocalDate birthdate = primaryOwner.getDateOfBirth();
        LocalDate now = LocalDate.now();
        Period period = birthdate.until(now);
        int age = period.getYears();

        AccountHolders secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null) {
            secondaryOwner = accountHoldersRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder does not exist"));
        }
        Account newAccount;
        if (age <= 24) {
            newAccount = studentCheckingRepository.save(new StudentChecking(primaryOwner, secondaryOwner));
        } else {
            newAccount = studentCheckingRepository.save(new StudentChecking(primaryOwner, secondaryOwner));
        }
        return newAccount;
    }



}
