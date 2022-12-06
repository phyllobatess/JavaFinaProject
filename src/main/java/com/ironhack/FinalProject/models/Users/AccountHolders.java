package com.ironhack.FinalProject.models.Users;

import jakarta.persistence.Embedded;

import java.time.LocalDate;
import java.util.Optional;

public class AccountHolders extends User {
    private LocalDate dateOfBirth;

    //Etiqueta para decirle que es una propiedad incrustada
    @Embedded
    private Address primaryAddress;

    @Embedded
    private Optional<Address> mailingAddress;

    public AccountHolders(){}
    public AccountHolders(String userName, String password, String name, LocalDate dateOfBirth, Address primaryAddress, Optional<Address> mailingAddress) {
        super(userName, password, name);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Optional<Address> getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Optional<Address> mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
