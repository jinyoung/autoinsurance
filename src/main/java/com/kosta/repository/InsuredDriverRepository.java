package com.kosta.repository;

import com.kosta.domain.InsuredDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "insured-driver", collectionResourceRel = "insured-driver")
public interface InsuredDriverRepository extends JpaRepository<InsuredDriver, Long> {
}
