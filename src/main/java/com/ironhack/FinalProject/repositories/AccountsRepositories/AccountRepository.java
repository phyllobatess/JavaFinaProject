package com.ironhack.FinalProject.repositories.AccountsRepositories;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.Users.AccountHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByIdAndPrimaryOwnerId(Long accountId, Long ownerId);
    Optional<Account> findByIdAndSecondaryOwnerId(Long accountId, Long accountHolderId);
}
