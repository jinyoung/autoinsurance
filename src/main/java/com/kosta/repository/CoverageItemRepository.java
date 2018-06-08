package com.kosta.repository;

import com.kosta.domain.CoverageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/coverage-item")
public interface CoverageItemRepository extends JpaRepository<CoverageItem, String> {
}
