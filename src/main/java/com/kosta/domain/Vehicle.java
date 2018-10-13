package com.kosta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class Vehicle {


	public Vehicle() {
	}

	public Vehicle(String type, String make, String model, String year, Customer customer) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.customer = customer;
	}

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private String type;
	private String make;
	private String model;
	private String year;
	private String primaryUsage;
	private String parkingZipcode;
	private String ownership;

	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.LAZY)
	@JoinColumn(name="CustomerID")
	private Customer customer;

	@JsonIgnore
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