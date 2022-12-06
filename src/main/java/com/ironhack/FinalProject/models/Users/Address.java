package com.ironhack.FinalProject.models.Users;

import jakarta.persistence.Embeddable;

//CLase que se puede incrustar
@Embeddable
public class Address {
    private String address;
    private Integer postalCode;
    private String country;
    public Address() {
    }

    public Address(String address, Integer postalCode, String country) {
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
