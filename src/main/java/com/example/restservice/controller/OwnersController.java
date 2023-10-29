package com.example.restservice.controller;

import com.example.restservice.controller.httpexceptions.ObjectAlreadyExistsException;
import com.example.restservice.data.Owner;
import com.example.restservice.data.OwnerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/owners")
public class OwnersController {

    private OwnerRepository ownerRepository;

    OwnersController(OwnerRepository repository) {
        this.ownerRepository = repository;
    }

    @GetMapping("/list")
    public Iterable<Owner> list() {
        return ownerRepository.findAll();
    }

    @GetMapping("/get/{name}")
    public Owner get(@PathVariable String name) {
        return ownerRepository.findByName(name);
    }

    @PostMapping("/add")
    public Owner add(@RequestBody Owner owner) {
        Owner existingOwner = ownerRepository.findByName(owner.getName());
        if(existingOwner != null) {
            throw new ObjectAlreadyExistsException();
        }
        return ownerRepository.save(owner);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String name) {
        Owner owner = ownerRepository.findByName(name);
        ownerRepository.delete(owner);
    }
}
