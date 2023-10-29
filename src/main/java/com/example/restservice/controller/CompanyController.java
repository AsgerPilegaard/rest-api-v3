package com.example.restservice.controller;

import com.example.restservice.controller.httpexceptions.NotFoundException;
import com.example.restservice.controller.httpexceptions.ObjectAlreadyExistsException;
import com.example.restservice.data.Company;
import com.example.restservice.data.CompanyRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/companies")
public class CompanyController {

    private CompanyRepository repository;

    CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public Iterable<Company> list() {
        return repository.findAll();
    }

    @GetMapping("/get/{companyName}")
    public Company get(@PathVariable String companyName) {
        return repository.findByCompanyName(companyName);
    }

    @PostMapping("/add")
    public Company add(@RequestBody Company company) {
        Company existingCompany = repository.findByCompanyName(company.getCompanyName());
        if(existingCompany != null) {
            throw new ObjectAlreadyExistsException();
        }
        return repository.save(company);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Company update(@RequestBody Company company) {
        Company updatedCompany = repository.findByCompanyName(company.getCompanyName());
        if(updatedCompany == null) {
            throw new NotFoundException();
        }
        company.setCountry(company.getCountry());
        company.setPhoneNumber(company.getPhoneNumber());
        return repository.save(updatedCompany);
    }

    @DeleteMapping("/delete/{companyName}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable String companyName) {
        Company company = repository.findByCompanyName(companyName);
        repository.delete(company);
    }

}