package com.ironhack.FinalProject.models;

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


}
