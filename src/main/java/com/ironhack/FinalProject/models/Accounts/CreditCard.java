package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class CreditCard extends Account {

    @NotNull
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal creditLimit=new BigDecimal("100");

    @NotNull
    @DecimalMin(value="0.1",inclusive = true)
    private double interestRate=0.2;

    private LocalDate lastTimeFeeApplied;

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal creditLimit, double interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public CreditCard(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner) {
        super(balance,primaryOwner,secondaryOwner);
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

    public LocalDate getLastTimeFeeApplied() {
        return lastTimeFeeApplied;
    }

    public void setLastTimeFeeApplied(LocalDate lastTimeFeeApplied) {
        this.lastTimeFeeApplied = lastTimeFeeApplied;
    }

    public void applyInterests() {
        Period period = Period.between(lastTimeFeeApplied, LocalDate.now());

        if (period.getMonths() == 1) {
            BigDecimal profit = super.getBalance().multiply(BigDecimal.valueOf(interestRate));
            super.setBalance(super.getBalance().add(profit).setScale(2, RoundingMode.HALF_DOWN));
            lastTimeFeeApplied = LocalDate.now();
        }
    }
}


