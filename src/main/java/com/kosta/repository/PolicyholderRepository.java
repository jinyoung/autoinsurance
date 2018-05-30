package com.kosta.repository;

import com.kosta.domain.Policyholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(path = "/policyholder")
public interface PolicyholderRepository extends JpaRepository<Policyholder, Long> {
}
