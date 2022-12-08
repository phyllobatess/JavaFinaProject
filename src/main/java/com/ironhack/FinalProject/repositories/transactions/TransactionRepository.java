package com.ironhack.FinalProject.repositories.transactions;

import com.ironhack.FinalProject.models.Movements.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
