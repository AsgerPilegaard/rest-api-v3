package com.example.restservice.controller;

import com.example.restservice.data.Owner;
import com.example.restservice.data.OwnerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/owners")
public class OwnersController {

    private Owner dummyOwner = new Owner("foo", "123");
    private OwnerRepository repository;

    OwnersController(OwnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public Iterable<Owner> list() {
        return repository.findAll();
    }

    @GetMapping("/company/{companyName}")
    public Iterable<Owner> listOwnersOfCompany(@PathVariable String companyName) {
        return Arrays.asList();
    }

    @GetMapping("/get/{name}")
    public Owner get(@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping("/add")
    public Owner add() {
        repository.findByName(dummyOwner.getName());
        return repository.save(dummyOwner);
    }

    @GetMapping("/update")
    public Owner update() {
        return repository.save(dummyOwner);
    }

    @GetMapping("/delete/{name}")
    public void delete(@PathVariable String name) {
        Owner owner = repository.findByName(name);
        repository.delete(owner);
    }
}
