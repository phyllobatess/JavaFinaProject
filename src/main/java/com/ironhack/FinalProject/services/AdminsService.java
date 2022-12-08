package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.models.Accounts.*;
import com.ironhack.FinalProject.models.DTO.AccountDTO;
import com.ironhack.FinalProject.models.DTO.BalanceDTO;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.models.Users.Admins;
import com.ironhack.FinalProject.repositories.AccountsRepositories.*;
import com.ironhack.FinalProject.repositories.UserRepositories.AccountHoldersRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.AdminsRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


@Service
public class AdminsService    {

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

    @Autowired
    AccountRepository accountRepository;


    public Admins addAdmin(Admins admin) {
        return adminsRepository.save(admin);
    }

    public Account addChecking(AccountDTO accountDto) {
        AccountHolders primaryOwner = accountHoldersRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Holder does not exist"));

        LocalDate DOB = primaryOwner.getDateOfBirth();
        LocalDate now = LocalDate.now();
        Period period = DOB.until(now);
        int age = period.getYears();

        AccountHolders secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null) {
            secondaryOwner = accountHoldersRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder does not exist"));
        }
        Account newAccount;
        if (age <= 24) {
            newAccount = studentCheckingRepository.save(new StudentChecking(accountDto.getBalance(),primaryOwner, secondaryOwner,accountDto.getSecretKey()));
        } else {
            newAccount = checkingRepository.save(new Checking(accountDto.getBalance(),primaryOwner, secondaryOwner,accountDto.getSecretKey()));
        }
        return newAccount;
    }







    public Account addSavings(AccountDTO accountDto)
    {
        AccountHolders primaryOwner=accountHoldersRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Account holder is not found in our DB"));

        AccountHolders secondaryOwner=null;
        if(accountDto.getSecondaryOwnerId()!=null)
        {
            secondaryOwner=accountHoldersRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
        }
        Savings savingsAccount;
        if(accountDto.getMinimumBalance() !=null && accountDto.getInterestRate() !=0){
            savingsAccount=new Savings(accountDto.getBalance(),primaryOwner,secondaryOwner,accountDto.getSecretKey(),accountDto.getMinimumBalance(),accountDto.getInterestRate());
        }
        else if(accountDto.getMinimumBalance()!=null){
            savingsAccount=new Savings(accountDto.getBalance(),primaryOwner,secondaryOwner,accountDto.getSecretKey(),new BigDecimal("0.0025"));
        }
        else if(accountDto.getInterestRate()!=0){
            savingsAccount=new Savings(accountDto.getBalance(),primaryOwner,secondaryOwner,accountDto.getSecretKey(),new BigDecimal("1000"),accountDto.getInterestRate());
        }
        else
        {
            savingsAccount=new Savings(accountDto.getBalance(),primaryOwner,secondaryOwner,accountDto.getSecretKey());
        }
        return savingsRepository.save(savingsAccount);

    }

    public Account addCreditCard(AccountDTO accountDto) {
        AccountHolders primaryOwner= accountHoldersRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account is not found"));

        AccountHolders secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null) {
            secondaryOwner = accountHoldersRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder not found"));
        }


        CreditCard creditCard;
        if (accountDto.getCreditLimit() != null && accountDto.getInterestRate() != 0) {
            creditCard = new CreditCard(accountDto.getBalance(),primaryOwner, secondaryOwner, accountDto.getCreditLimit(), accountDto.getInterestRate());
        } else if (accountDto.getCreditLimit() != null) {
            creditCard = new CreditCard(accountDto.getBalance(),primaryOwner, secondaryOwner, accountDto.getCreditLimit(), 0.2);
        } else if (accountDto.getInterestRate() != 0) {
            creditCard = new CreditCard(accountDto.getBalance(),primaryOwner, secondaryOwner, new BigDecimal(100), accountDto.getInterestRate());
        } else {
            creditCard = new CreditCard(accountDto.getBalance(),primaryOwner, secondaryOwner);
        }
        return creditCardRepository.save(creditCard);

    }


    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"The account does not exist in our DataBase"));
    }


    public Account updateAccountBalance(BalanceDTO balanceDto) {
        Account account = accountRepository.findById(balanceDto.getAccountId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        BigDecimal newBalance = balanceDto.getNewBalance();
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public void deleteById(Long id) {
        accountRepository.delete(accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found")));
    }




}
