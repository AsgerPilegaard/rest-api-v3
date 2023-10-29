package com.example.restservice.controller;

import com.example.restservice.data.Company;
import com.example.restservice.data.CompanyRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping("/companies")
public class CompanyController {

    private Company dummyCompany = new Company("companyName", "Denmark", "12345678");
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

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Company add() {
        repository.findByCompanyName(dummyCompany.getCompanyName());
        return repository.save(dummyCompany);
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Company update() {
        return repository.save(dummyCompany);
    }

    @GetMapping("/delete/{companyName}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable String companyName) {
        Company company = repository.findByCompanyName(companyName);
        repository.delete(company);
    }

}