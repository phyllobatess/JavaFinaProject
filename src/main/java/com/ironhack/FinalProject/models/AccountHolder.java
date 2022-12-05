package com.ironhack.FinalProject.models;

import jakarta.persistence.Embedded;

import java.time.LocalDate;
import java.util.Optional;

public class AccountHolder extends User {
    private LocalDate dateOfBirth;

    @Embedded
    private Address primaryAddress;

    @Embedded
    private Optional<Address> mailingAddress;


}
