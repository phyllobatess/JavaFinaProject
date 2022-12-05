package com.ironhack.FinalProject.models;

import jakarta.persistence.Embeddable;

//CLase que se puede incrustar
@Embeddable
public class Address {
    private String address;
    private Integer postalCode;
    private String country;
    private boolean insideEU;
}
