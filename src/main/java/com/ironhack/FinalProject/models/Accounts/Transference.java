package com.ironhack.FinalProject.models.Accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transference {
    @Id
    private String transferenceNumber;
}
