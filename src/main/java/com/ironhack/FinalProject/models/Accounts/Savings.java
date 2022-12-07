package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Savings extends Account {
    private String secretKey;

    @NotNull
    @DecimalMin(value = "100", inclusive = true)
    private BigDecimal minimumBalance=new BigDecimal("1000");

    @NotNull
    @DecimalMax(value = "0.5", inclusive = true)
    private double interestRate=0.0025;

    @NotNull
    private LocalDate creationDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status savingsAccountStatus;

    final BigDecimal minBal=new BigDecimal("100");
    final BigDecimal maxBal=new BigDecimal("1000");


    public Savings() {
    }

    //Constructor que no pida el InterestRate (lo pone por defecto a 0.0025) y Sí pide Minimumbalance:
    public Savings(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, LocalDate creationDate, Status savingsAccountStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.savingsAccountStatus = savingsAccountStatus;

        interestRate = 0.0025;
        setMinimumBalance(minimumBalance);
    }


    //Constructor que no pide el InterestRate y no pide el minimumbalance, se lo ponemos por defecto:
    public Savings(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, String secretKey, LocalDate creationDate, Status savingsAccountStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.savingsAccountStatus = savingsAccountStatus;

        interestRate = 0.0025;
        minimumBalance=new BigDecimal("1000");
    }

    //Constructor que SI pide InterestRate  y SI pide minimumbalace.
    public Savings(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, double interestRate, LocalDate creationDate, Status savingsAccountStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.savingsAccountStatus = savingsAccountStatus;

        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
    }

    //Constructor que SI pide Interest rate y NO pide minimumbalance:
    public Savings(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, String secretKey, double interestRate, LocalDate creationDate, Status savingsAccountStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.savingsAccountStatus = savingsAccountStatus;


        setInterestRate(interestRate);
        minimumBalance=new BigDecimal("1000");

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
        if(minimumBalance.compareTo(minBal)==1 && minimumBalance.compareTo(maxBal)==-1 || minimumBalance.compareTo(maxBal)==0){
            this.minimumBalance=minimumBalance;
        }
        else this.minimumBalance=new BigDecimal("1000");
    }

    public double getInterestRate() {
        return interestRate;
    }

    //Seteamos el valor del interesRate para que esté comprendido entre 0 y 0.5
    public void setInterestRate(double interestRate) {
        if(interestRate>0 && interestRate<=0.5)
        {
            this.interestRate = interestRate;
        }
        else {
            this.interestRate=0.0025;
        }

    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getSavingsAccountStatus() {
        return savingsAccountStatus;
    }

    public void setSavingsAccountStatus(Status savingsAccountStatus) {
        this.savingsAccountStatus = savingsAccountStatus;
    }
}
