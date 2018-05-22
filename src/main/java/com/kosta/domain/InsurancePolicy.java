package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity @Data
public class InsurancePolicy {

	@OneToOne
	@JoinColumn(name = "VehicleID")
	Vehicle vehicle;

	@ManyToMany
	@JoinTable(name = "selectedoption",
			joinColumns = @JoinColumn(name = "CoverageItemOptionID"),
			inverseJoinColumns = @JoinColumn(name = "InsurancePolicyID")
	)
	Collection<CoverageItemOption> coverageItemOptions;

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