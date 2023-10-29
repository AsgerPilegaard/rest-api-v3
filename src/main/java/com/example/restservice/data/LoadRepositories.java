package com.example.restservice.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadRepositories {

	@Bean
	protected CommandLineRunner initCompanyRepository(CompanyRepository repository) {
		return (args) -> {
			repository.save(new Company("company1", "Denmark", "+4512345678"));
			repository.save(new Company("company2", "Denmark", "+4512345678"));
		};
	}

	@Bean
	protected CommandLineRunner initOwnerRepository(OwnerRepository repository) {
		return (args) -> {
			repository.save(new Owner("owner1", "010120001234"));
			repository.save(new Owner("owner2", "010120001234"));
		};
	}

}
