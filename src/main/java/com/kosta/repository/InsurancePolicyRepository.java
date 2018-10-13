package com.kosta.repository;

import com.kosta.domain.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "insurance-policy", collectionResourceRel = "insurance-policy")
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
}
