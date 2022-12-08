package com.ironhack.FinalProject.controllers.interfaces;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import com.ironhack.FinalProject.models.Users.Admins;

public interface AdminsControllerInt {
    Admins addNewAdmin(Admins admin);
    AccountHolders addNewAccountHolders(AccountHolders accountHolders);
}
