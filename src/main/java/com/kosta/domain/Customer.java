package com.kosta.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity @Data
public class Customer {

	@OneToMany(mappedBy = "customer")
	List<Vehicle> vehicles;

	@Id
	private String ID;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String driverLicenseNumber;
	private int socialSecurityNumber;
	private String gender;
	private String marritalStatus;

	/**
	 * Returns Customer.ID
	 */
	public int registerCustomer() {
		// TODO - implement Customer.registerCustomer
		throw new UnsupportedOperationException();
	}

	public void updateCustomer() {
		// TODO - implement Customer.updateCustomer
		throw new UnsupportedOperationException();
	}

}