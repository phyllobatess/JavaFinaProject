package com.ironhack.FinalProject.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Savings extends Account {
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal interestRate;
    private LocalDate creationDate;
    private Status savingsAccountStatus;
}
