package com.ironhack.FinalProject.repositories;

import com.ironhack.FinalProject.models.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings,Long> {
}
