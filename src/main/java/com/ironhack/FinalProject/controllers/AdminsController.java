package com.ironhack.FinalProject.controllers;

import com.ironhack.FinalProject.controllers.interfaces.AdminsControllerInt;
import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.DTO.AccountDTO;
import com.ironhack.FinalProject.models.DTO.BalanceDTO;
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
public class AdminsController implements AdminsControllerInt {

    @Autowired
    AdminsService adminsService;
    @Autowired
    AccountHoldersService accountHoldersService;
    @Autowired
    ThirdPartyService thirdPartyService;

//La cuenta tipo ADMIN es la que nos permite crear cuentas de tipo CHECKING or CREDIT CARD no STUDENT.

    //Ruta que nos añadir un nuevo ADMINS:
    @PostMapping("/add-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins addNewAdmin(@RequestBody Admins admin){
        return adminsService.addAdmin(admin);
    }

    //Ruta que nos añade un nuevo AccountHolder:
    @PostMapping("/add-account-holders")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolders addNewAccountHolders(@RequestBody AccountHolders accountholders){
        return accountHoldersService.addAccountHolder(accountholders);
    }

    //Ruta que nos añade un nuevo ThirdParty:
    @PostMapping("/add-third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addNewThirdParty(@RequestBody ThirdParty thirdParty){
        return thirdPartyService.addAThirdParty(thirdParty);
    }




    @PostMapping("/add-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addChecking(@RequestBody AccountDTO accountDto)
    {
        return adminsService.addChecking(accountDto);
    }


    @PostMapping("/add-savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addSavings(@RequestBody AccountDTO accountDto){
        return adminsService.addSavings(accountDto);
    }

    @PostMapping("/add-credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addCreditCard(@RequestBody AccountDTO accountDto)
    {
        return adminsService.addCreditCard(accountDto);
    }


    @GetMapping("/find-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findAccountById(@PathVariable Long id) {
        return adminsService.getAccount(id);
    }

    //No sé si esta bien:
    @PatchMapping("/account/update-balance")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccountBalanceById(@RequestBody BalanceDTO balanceDto){
        return adminsService.updateAccountBalance(balanceDto);
    }

    @DeleteMapping("/delete-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountById(@PathVariable Long id){
        adminsService.deleteById(id);
    }

}
