package com.kosta.repository;

import com.kosta.domain.PremiumPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "preminum-payment", collectionResourceRel = "premium-payment")
public interface PremiumPaymentRepository extends JpaRepository<PremiumPayment, String> {
}
