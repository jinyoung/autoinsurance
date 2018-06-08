package com.kosta.repository;

import com.kosta.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/customer")
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
