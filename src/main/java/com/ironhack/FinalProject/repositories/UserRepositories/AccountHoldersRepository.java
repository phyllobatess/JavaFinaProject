package com.ironhack.FinalProject.repositories.UserRepositories;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountHoldersRepository extends JpaRepository<AccountHolders,Long> {
    Optional<Account> findPrimaryOwnerAccountById(Long id);
    Optional<Account> findSecondaryOwnerAccountById(Long id);
}
