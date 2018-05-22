package com.kosta.repository;

import com.kosta.domain.CoverageItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/coverage-item-options")
public interface CoverageItemOptionRepository extends JpaRepository<CoverageItemOption, String> {
}
