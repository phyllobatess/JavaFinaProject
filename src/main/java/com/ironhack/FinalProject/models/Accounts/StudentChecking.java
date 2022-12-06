package com.ironhack.FinalProject.models.Accounts;

import com.ironhack.FinalProject.models.Users.AccountHolders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class StudentChecking extends Account {
    private String secretKey;
    private LocalDate creationDate;
    private Status studentCheckingStatus;

    public StudentChecking(BigDecimal balance, AccountHolders primaryOwner, Optional<AccountHolders> secondaryOwner, BigDecimal penaltyFee, String secretKey, LocalDate creationDate, Status studentCheckingStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.studentCheckingStatus = studentCheckingStatus;
    }

    public StudentChecking() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStudentCheckingStatus() {
        return studentCheckingStatus;
    }

    public void setStudentCheckingStatus(Status studentCheckingStatus) {
        this.studentCheckingStatus = studentCheckingStatus;
    }
}
