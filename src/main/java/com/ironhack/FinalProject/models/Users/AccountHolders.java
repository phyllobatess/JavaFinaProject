package com.ironhack.FinalProject.models.Users;

import com.ironhack.FinalProject.models.Accounts.Account;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class AccountHolders extends User {


    private LocalDate dateOfBirth;

    //Etiqueta para decirle que es una propiedad incrustada
    @Embedded
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="address",column=@Column(name="mailing_address")),
        @AttributeOverride(name="postalCode",column=@Column(name="mailing_postal_code")),
        @AttributeOverride(name="country",column=@Column(name="mailing_country")),
    })
    private Address mailingAddress;

    //Relaciones entre la clase USER y ACCOUNT:
    @OneToMany(cascade=CascadeType.ALL, mappedBy="primaryOwner")
    private List<Account> primaryOwnerAccounts=new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy="secondaryOwner")
    private List<Account> secondaryOwnerAccounts=new ArrayList<>();



    //CONSTRUCTORES GETTERS Y SETTERS:

    public AccountHolders(){}

    public AccountHolders(String userName, String password, String name, LocalDate dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(userName, password, name);
        setDateOfBirth(dateOfBirth);
        setPrimaryAddress(primaryAddress);
        setMailingAddress(mailingAddress);
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

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }



    //Getters y setter de las listas:
    public List<Account> getPrimaryOwnerAccounts() {
        return primaryOwnerAccounts;
    }

    public void setPrimaryOwnerAccounts(List<Account> primaryOwnerAccounts) {
        this.primaryOwnerAccounts = primaryOwnerAccounts;
    }

    public List<Account> getSecondaryOwnerAccounts() {
        return secondaryOwnerAccounts;
    }

    public void setSecondaryOwnerAccounts(List<Account> secondaryOwnerAccounts) {
        this.secondaryOwnerAccounts = secondaryOwnerAccounts;
    }
}

