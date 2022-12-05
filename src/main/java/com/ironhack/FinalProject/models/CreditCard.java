package com.ironhack.FinalProject.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CreditCard extends Account {
    private BigDecimal creditLimit;
    private BigDecimal interestRate;
}
