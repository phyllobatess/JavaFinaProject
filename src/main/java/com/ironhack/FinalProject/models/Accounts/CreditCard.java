package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CreditCard extends Account {
    private BigDecimal creditLimit;
    private double interestRate;

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, BigDecimal creditLimit, double interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

