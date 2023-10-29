package com.example.restservice.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

	Company findByCompanyName(String companyName);
	Company findById(long id);
}
