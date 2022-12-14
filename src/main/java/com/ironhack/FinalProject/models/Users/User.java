package com.ironhack.FinalProject.models.Users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    private String name;

    protected User() {
    }

    public User(String userName, String password, String name) {
        setUserName(userName);
        setPassword(password);
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
