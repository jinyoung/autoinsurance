package com.kosta.repository;

import com.kosta.domain.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "insurance-product", collectionResourceRel = "insurance-product")
public interface InsuranceProductRepository extends JpaRepository<InsuranceProduct, String> {
}
