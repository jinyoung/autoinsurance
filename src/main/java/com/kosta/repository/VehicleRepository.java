package com.kosta.repository;

import com.kosta.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "vehicle", collectionResourceRel = "vehicle")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
