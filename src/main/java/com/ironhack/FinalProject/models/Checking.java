package com.ironhack.FinalProject.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account {
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    private LocalDate creationDate;
    private Status checkingAccountStatus;
}
