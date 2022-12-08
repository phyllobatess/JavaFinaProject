package com.ironhack.FinalProject.models.Accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.FinalProject.models.Movements.Transaction;
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
    private final BigDecimal penaltyFee=new BigDecimal("40");


    //     T R A N S A C T I O N   R E L A T I O N S
    @JsonIgnore
    @OneToMany(mappedBy = "destinyAccount", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaction> sentTransference = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "originAccount", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaction> receivedTransference = new ArrayList<>();



    //Constructor vacío
    public Account(){}

    //Constructor que no pida el secondary Owner
    public Account(BigDecimal balance, AccountHolders primaryOwner) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);

    }

    //Constructor que pida el Secondary Owner:
    public Account(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;

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

    public List<Transaction> getSentTransference() {
        return sentTransference;
    }

    public void setSentTransference(List<Transaction> sentTransference) {
        this.sentTransference = sentTransference;
    }

    public List<Transaction> getReceivedTransference() {
        return receivedTransference;
    }

    public void setReceivedTransference(List<Transaction> receivedTransference) {
        this.receivedTransference = receivedTransference;
    }
}



