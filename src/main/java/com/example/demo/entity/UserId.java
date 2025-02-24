package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {
    private Long id;

    public UserId(){}
    public UserId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}