package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Checking extends Account {
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    private LocalDate creationDate;
    private Status checkingAccountStatus;


    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, LocalDate creationDate, Status checkingAccountStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = creationDate;
        this.checkingAccountStatus = checkingAccountStatus;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getCheckingAccountStatus() {
        return checkingAccountStatus;
    }

    public void setCheckingAccountStatus(Status checkingAccountStatus) {
        this.checkingAccountStatus = checkingAccountStatus;
    }
}
