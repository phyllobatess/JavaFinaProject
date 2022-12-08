package com.ironhack.FinalProject.models.Movements;

import com.ironhack.FinalProject.models.Accounts.Account;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


   @NotNull
    private BigDecimal amount;

   @ManyToOne
   @JoinColumn(name = "destiny_account_id")
   private Account destinyAccount;

   @ManyToOne
   @JoinColumn(name = "origin_account_id")
   private Account originAccount;

   private LocalDateTime time=LocalDateTime.now();


    public Transaction(BigDecimal amount, Account destinyAccount, Account originAccount) {
        setAmount(amount);
        setDestinyAccount(destinyAccount);
        setOriginAccount(originAccount);

    }

    public Transaction() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(Account destinyAccount) {
        this.destinyAccount = destinyAccount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
