package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class InsuredDriver {

	@Id @GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "insurance_policy_id")
	private InsurancePolicy insurancePolicy;

	private String relationToPolicyholder;

	public void setRelation() {
		// TODO - implement InsuredDriver.setRelation
		throw new UnsupportedOperationException();
	}

}