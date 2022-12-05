package com.ironhack.FinalProject.repositories;

import com.ironhack.FinalProject.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
