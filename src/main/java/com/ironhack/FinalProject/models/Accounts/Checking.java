package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Checking extends Account {
    private String secretKey;
    @NotNull
    private final BigDecimal minimumBalance=new BigDecimal("250");

    @NotNull
    private final BigDecimal monthlyMaintenanceFee=new BigDecimal("12");

    @NotNull
    private LocalDate creationDate=LocalDate.now();

    //Se inicializa con el estado por defecto ACTIVO:
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status checkingAccountStatus=Status.ACTIVE;


    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
    }

    public Checking(AccountHolders primaryOwner, AccountHolders secondaryOwner) {
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



    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
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
