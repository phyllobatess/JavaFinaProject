package com.ironhack.FinalProject.repositories.AccountsRepositories;

import com.ironhack.FinalProject.models.Accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking,Long> {
}
