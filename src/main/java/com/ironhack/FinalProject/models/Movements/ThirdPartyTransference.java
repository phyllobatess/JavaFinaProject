package com.ironhack.FinalProject.models.Movements;

import com.ironhack.FinalProject.models.Accounts.Account;
import com.ironhack.FinalProject.models.Users.ThirdParty;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Entity
public class ThirdPartyTransference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @NotNull
    @ManyToOne
    @JoinColumn(name="thirdParty_id")
    private ThirdParty thirdParty;

    public ThirdPartyTransference() {
    }

    public ThirdPartyTransference(@NotNull BigDecimal amount, Account account, @NotNull ThirdParty thirdParty) {
        this.amount = amount;
        this.account = account;
        this.thirdParty = thirdParty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ThirdParty getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }
}
