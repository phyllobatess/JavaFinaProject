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
public class StudentChecking extends Account {
    private String secretKey;

    @NotNull
    private LocalDate creationDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status studentCheckingStatus;

    public StudentChecking(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, String secretKey, LocalDate creationDate, Status studentCheckingStatus) {
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
