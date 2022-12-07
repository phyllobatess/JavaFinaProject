package com.ironhack.FinalProject.controllers;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.Accounts.Checking;
import com.ironhack.FinalProject.models.DTO.AccountDto;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.models.Users.Admins;
import com.ironhack.FinalProject.models.Users.ThirdParty;
import com.ironhack.FinalProject.services.AccountHoldersService;
import com.ironhack.FinalProject.services.AdminsService;
import com.ironhack.FinalProject.services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminsController {

    @Autowired
    AdminsService adminsService;
    @Autowired
    AccountHoldersService accountHoldersService;
    @Autowired
    ThirdPartyService thirdPartyService;

//La cuenta tipo ADMIN es la que nos permite crear cuentas de tipo CHECKING or CREDIT CARD no STUDENT.

    //Ruta que nos guarda un nuevo ADMINS:
    @PostMapping("/add-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins addNewAdmin(@RequestBody Admins admin){
        return adminsService.addAdmin(admin);
    }

    //Ruta que nos guarda un nuevo AccountHolder:
    @PostMapping("/add-account-holders")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolders addNewAccountHolders(@RequestBody AccountHolders accountholders){
        return accountHoldersService.addAccountHolder(accountholders);
    }

    //Ruta que nos guarda un nuevo ThirdParty:
    @PostMapping("/add-third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addNewThirdParty(@RequestBody ThirdParty thirdParty){
        return thirdPartyService.addAThirdParty(thirdParty);
    }

    //_________________Falta Add-checking-acc, savings y credit card________________


    //Si el primaryOwner es >24--> Checking account, si es <24 --> Student
    @PostMapping("/add-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addChecking(@RequestBody AccountDto accountDto)
    {
        return adminsService.addChecking(accountDto);
    }


    @GetMapping("/client-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findAccountById(@PathVariable Long id) {
        return adminsService.getAccount(id);
    }

// Falta el PATCH




}
