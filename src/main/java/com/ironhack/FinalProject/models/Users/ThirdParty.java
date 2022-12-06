package com.ironhack.FinalProject.models.Users;

public class ThirdParty extends User {
    private String hashKey;

    public ThirdParty(){}
    public ThirdParty(String userName, String password, String name, String hashKey) {
        super(userName, password, name);
        this.hashKey = hashKey;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}