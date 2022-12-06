package com.ironhack.FinalProject.repositories.Accounts;

import com.ironhack.FinalProject.models.Accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings,Long> {
}
