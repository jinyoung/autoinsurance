package com.kosta.repository;

import com.kosta.domain.CoverageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.scheduling.support.SimpleTriggerContext;

@RepositoryRestResource(path = "/coverage-items")
public interface CoverageItemRepository extends JpaRepository<CoverageItem, String> {
}
