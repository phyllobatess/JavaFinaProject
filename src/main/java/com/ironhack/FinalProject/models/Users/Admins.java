package com.ironhack.FinalProject.models.Users;

import jakarta.persistence.Entity;

@Entity
public class Admins extends User {
    public Admins() {
    }

    public Admins(String userName, String password, String name) {
        super(userName, password, name);
    }


}
