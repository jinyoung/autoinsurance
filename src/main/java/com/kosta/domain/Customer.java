package com.kosta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kosta.AutoInsuranceApplication;
import com.kosta.service.CreditRate;
import com.kosta.service.external.CRMService;
import com.kosta.service.external.CreditService;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity @Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

	@Transient @JsonIgnore
	CRMService crmService;

	@Transient @JsonIgnore
	CreditService creditService;

	public Customer() {
		crmService = AutoInsuranceApplication.applicationContext.getBean(CRMService.class);
		creditService = AutoInsuranceApplication.applicationContext.getBean(CreditService.class);
	}


	@OneToMany(mappedBy = "customer")
	List<Vehicle> vehicles;

	@Id
	@Column(name = "customer_id")
	private String id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String streetAddress;
	private String aptUnitNumber;
	private String city;
	private String state;
	private String zipcode;
	private String socialSecurityNumber;
	private String creditRate;
	private String gender;
	private String marritalStatus;
	private String driverLicenseNumber;

	@OneToMany(mappedBy = "customer")
	private List<InsuredDriver> insuredDrivers;

	/**
	 * Returns Customer.ID
	 */
	@PrePersist
	public void registerCustomer() throws IllegalStateException {
		setId(crmService.getCustomerID(this));
	}

	@PostUpdate
	public void updateCustomer() throws IllegalStateException {
		if(!getSocialSecurityNumber().isEmpty()){
			checkCreditRate();
		}
	}

	private void checkCreditRate() {
		//Spring Version
		CreditRate cr = creditService.getCredit(this);
		setCreditRate(cr.toString());
		if(cr.compareTo(CreditRate.C) >= 0){
			throw new IllegalStateException("CreditRate should be higher then 'C'");
		}
    }


}