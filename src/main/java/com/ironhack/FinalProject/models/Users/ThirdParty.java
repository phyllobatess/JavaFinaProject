package com.ironhack.FinalProject.models.Users;

import jakarta.persistence.Entity;

@Entity
public class ThirdParty extends User {
    private String hashKey;

    public ThirdParty(){}
    public ThirdParty(String userName, String password, String name, String hashKey) {
        super(userName, password, name);
        setHashKey(hashKey);
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}
