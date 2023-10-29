package com.example.restservice.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Random;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String socialSecurityNumber;

    protected Owner() {
    }

    public Long getId() {
        return id;
    }

    public Owner(String name, String socialSecurityNumber) {
        this.id = new Random().nextLong();
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialSecurityNumber() {
        if (new Random().nextBoolean()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}
