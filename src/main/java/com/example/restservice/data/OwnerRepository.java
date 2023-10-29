package com.example.restservice.data;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByName(String name);

    Owner findById(long id);
}
