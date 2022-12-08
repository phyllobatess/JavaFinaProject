package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Entity
public class CreditCard extends Account {

    @NotNull
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal creditLimit=new BigDecimal("100");

    @NotNull
    @DecimalMin(value="0.1",inclusive = true)
    private double interestRate=0.2;

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal creditLimit, double interestRate) {
        super(balance, primaryOwner, secondaryOwner);
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

