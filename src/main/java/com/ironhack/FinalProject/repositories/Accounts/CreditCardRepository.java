package com.ironhack.FinalProject.repositories.Accounts;

import com.ironhack.FinalProject.models.Accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
