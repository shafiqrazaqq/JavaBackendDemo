package com.example.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
    @EmbeddedId
    private UserId id;

    private String username;
    private String name;

    public User() {} // Add a no-argument constructor

    public User(UserId id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    // Getters and setters...
    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}