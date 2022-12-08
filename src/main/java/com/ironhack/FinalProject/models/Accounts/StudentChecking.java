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
    private LocalDate creationDate=LocalDate.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status studentCheckingStatus=Status.ACTIVE;

    public StudentChecking(BigDecimal balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
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
