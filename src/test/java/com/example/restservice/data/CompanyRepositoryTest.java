package com.example.restservice.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompanyRepository companies;

    @Test
    public void findByCompanyNameWorks() {
        Company company = new Company("foo", "bar", "too", Arrays.asList("fooboo"));
        Company persisted = entityManager.persist(company);
        Company found = companies.findByCompanyName(company.getCompanyName());

        assertThat(found).isEqualTo(persisted);
    }

    @Test
    public void findByIdWorks() {
        Company company = new Company("foo", "bar", "too", Arrays.asList("fooboo"));
        Company persisted = entityManager.persist(company);
        Company found = companies.findById(company.getId()).get();

        assertThat(found).isEqualTo(persisted);
    }
}