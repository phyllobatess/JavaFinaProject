package com.ironhack.FinalProject.controllers.interfaces;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.DTO.AccountDTO;
import com.ironhack.FinalProject.models.DTO.BalanceDTO;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.models.Users.Admins;
import com.ironhack.FinalProject.models.Users.ThirdParty;

import java.math.BigDecimal;

public interface AdminsControllerInt {
    Admins addNewAdmin(Admins admin);
    AccountHolders addNewAccountHolders(AccountHolders accountHolders);
    ThirdParty addNewThirdParty(ThirdParty thirdParty);

    Account addChecking(AccountDTO accountDTO);

    Account addSavings(AccountDTO accountDTO);
    Account addCreditCard(AccountDTO accountDTO);

    BigDecimal findAccountBalance(Long id);
    Account findAccountById(Long id);

    Account updateAccountBalanceById(BalanceDTO balanceDTO);

    void deleteAccountById(Long id);
}
