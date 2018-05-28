package com.kosta.domain;

import com.kosta.AutoInsuranceApplication;
import com.kosta.service.CRMService;
import com.kosta.service.CreditRate;
import com.kosta.service.CreditService;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity @Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

	@OneToMany(mappedBy = "customer")
	List<Vehicle> vehicles;

	@Id
	private String ID;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String streetAddress;
	private String aptUnitNumber;
	private String city;
	private String state;
	private String zipcode;
	private int socialSecurityNumber;
	private String cerditRate;
	private String gender;
	private String marritalStatus;

	/**
	 * Returns Customer.ID
	 */
	@PrePersist
	public void registerCustomer() throws IllegalStateException {
		setID(AutoInsuranceApplication.applicationContext.
			getBean(CRMService.class).getCustomerID(this));
	}

	@PostUpdate
	public void updateCustomer() throws IllegalStateException {
		if(getSocialSecurityNumber()!=0){
			checkCreditRate();
		}
	}

	private void checkCreditRate() {
		//Spring Version
		CreditRate cr = AutoInsuranceApplication.applicationContext.getBean(CreditService.class).getCredit(this);
		setCerditRate(cr.toString());
		if(cr.compareTo(CreditRate.C) >= 0){
			throw new IllegalStateException("CreditRate should be higher then 'C'");
		}
	}


}