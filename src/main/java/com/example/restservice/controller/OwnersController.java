package com.example.restservice.controller;

import com.example.restservice.data.Owner;
import com.example.restservice.data.OwnerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/owners")
public class OwnersController {

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

    @PostMapping("/add")
    public Owner add(@RequestBody Owner owner) {
        Owner existingOwner = repository.findByName(owner.getName());
        if(existingOwner != null) {
            throw new ObjectAlreadyExistsException();
        }
        return repository.save(owner);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String name) {
        Owner owner = repository.findByName(name);
        repository.delete(owner);
    }
}
