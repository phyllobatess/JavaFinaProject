package com.ironhack.FinalProject.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;
    private AccountHolder primaryOwner;
    private Optional<AccountHolder> secondaryOwner;
    private BigDecimal penaltyFee;


}
