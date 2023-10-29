package com.example.restservice.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String country;
    private String phoneNumber;

    protected Company() {
    }

    public Company(String companyName, String country, String phoneNumber) {
        this.companyName = companyName;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
