package com.ironhack.FinalProject.repositories.AccountsRepositories;

import com.ironhack.FinalProject.models.Accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepository extends JpaRepository<Checking,Long> {
}
