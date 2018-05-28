package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data
public class Vehicle {


	public Vehicle() {
	}

	public Vehicle(String ID, String type, String make, String model, LocalDate year, Customer customer) {
		this.ID = ID;
		this.type = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.customer = customer;
	}

	@Id
	private String ID;
	private String type;
	private String make;
	private String model;
	private LocalDate year;
	private String primaryUsage;
	private String parkingZipcode;
	private String ownership;

	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.LAZY)
	@JoinColumn(name="CustomerID")
	private Customer customer;


	@OneToOne(mappedBy = "vehicle")
	private InsurancePolicy insurancePolicy;

	/**
	 * Returns Vehicle.ID : String for all Vehicle owned by Customer
	 * @param socialSecurityNumber
	 */
	public String getAllVehiclesOwnedbyCustomer(int socialSecurityNumber) {
		// TODO - implement Vehicle.getAllVehiclesOwnedbyCustomer
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns Vehicle.ID for Vehicle to insure
	 * @param vehiclesOwned A set of Vehicle.ID from which to choose one to insure
	 */
	public String selectVehicleToInsure(String[] vehiclesOwned) {
		// TODO - implement Vehicle.selectVehicleToInsure
		throw new UnsupportedOperationException();
	}

	public void updateVehicle() {
		// TODO - implement Vehicle.updateVehicle
		throw new UnsupportedOperationException();
	}

}