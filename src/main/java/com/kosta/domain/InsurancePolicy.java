package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity @Data
public class InsurancePolicy {

	@ManyToOne
	private Policyholder policyholder;

	@OneToOne
	@JoinColumn(name = "VehicleID")
	private Vehicle vehicle;

	@ManyToMany
	@JoinTable(
			joinColumns = @JoinColumn(name = "coverage_item_optionid"),
			inverseJoinColumns = @JoinColumn(name = "insurance_policy_id")
	)
	private Collection<CoverageItemOption> coverageItemOptions;

	@OneToMany
	Collection<InsuredDriver> insuredDrivers;

	@Id
	private String ID;
	private String state;
	private Date coveageStartDate;
	private BigDecimal insurancePremium;
	private String billPlan;
	private char[] signature;

	/**
	 * Returns .InsurancePolicy.ID
	 * @param CustomerID
	 * @param VehicleID
	 */
	public String createPolicy(int CustomerID, String VehicleID) {
		// TODO - implement InsurancePolicy.createPolicy
		throw new UnsupportedOperationException();
	}

	public void updatePolicy() {
		// TODO - implement InsurancePolicy.updatePolicy
		throw new UnsupportedOperationException();
	}

	public void producePolicyDocument() {
		// TODO - implement InsurancePolicy.producePolicyDocument
		throw new UnsupportedOperationException();
	}

}