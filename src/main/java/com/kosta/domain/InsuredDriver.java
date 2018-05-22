package com.kosta.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity @Data
public class InsuredDriver extends Customer {

	@ManyToOne(targetEntity = InsurancePolicy.class)
	@JoinColumn(name = "InsurancePolicyID")
	InsurancePolicy insurancePolicy;

	private String relationToPolicyholder;

	public void setRelation() {
		// TODO - implement InsuredDriver.setRelation
		throw new UnsupportedOperationException();
	}

}