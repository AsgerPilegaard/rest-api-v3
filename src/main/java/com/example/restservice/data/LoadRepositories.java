package com.example.restservice.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LoadRepositories {

	private Owner ownerOne = new Owner("owner1", "010120001234");
	private Owner ownerTwo = new Owner("owner2", "010120001234");
	private Company companyOne = new Company(
			"company1",
			"Denmark",
			"+4512345678",
			Arrays.asList(ownerOne.getName()));
	private Company companyTwo = new Company(
			"company2",
			"Denmark",
			"+4512345678",
			Arrays.asList(ownerOne.getName(), ownerTwo.getName()));

	@Bean
	protected CommandLineRunner initCompanyRepository(CompanyRepository repository) {
		return (args) -> {
			repository.save(companyOne);
			repository.save(companyTwo);
		};
	}

	@Bean
	protected CommandLineRunner initOwnerRepository(OwnerRepository repository) {
		return (args) -> {
			repository.save(ownerOne);
			repository.save(ownerTwo);
		};
	}

}
