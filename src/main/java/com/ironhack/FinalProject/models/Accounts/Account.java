package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance=new BigDecimal("0");

    //Relaciones con la clase AccountHolder:

    @NotNull
    @ManyToOne
    @JoinColumn(name="primaryOwner_id")
    private AccountHolders primaryOwner;
    @ManyToOne
    @JoinColumn(name="secondaryOwner_id")
    private AccountHolders secondaryOwner;

    private BigDecimal penaltyFee=new BigDecimal("40");





    //Constructor vacío
    public Account(){}

    //Constructor que no pida el secondary Owner
    public Account(BigDecimal balance, AccountHolders primaryOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.penaltyFee = penaltyFee;
    }

    //Constructor que pida el Secondary Owner:
    public Account(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountHolders getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolders primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolders getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolders secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}



