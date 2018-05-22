package com.kosta.domain;

import com.kosta.service.CRMService;
import com.kosta.service.CreditRate;
import com.kosta.service.CreditService;
import com.kosta.service.DMVService;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.IOException;

@Entity @Data
public class Policyholder extends Customer {

	private String streetAddress;
	private String aptUnitNumber;
	private String city;
	private String state;
	private String zipcode;
	private String cerditRate;
	private String driverLicenseStatus;
	private String highestEduLevel;
	private String accidentHistory;
	private String emailAddress;
	private String healthInsurance;
	private String previousInsuranceCarrier;
	private String previousInsurancePolicyID;

	public void updatePolicyholder() {
		// TODO - implement Policyholder.updatePolicyholder
		throw new UnsupportedOperationException();
	}

	public void registerVehicleToInsure(){
		DMVService ds = DMVService.getService();
		setDriverLicenseNumber(ds.getDriverLicenseNumber(this));
		setDriverLicenseStatus(ds.getDriverLicenseStatus(this));
	}
	@PrePersist
	public void validate() throws IOException {

		this.setID(CRMService.getService().getCustomerID(this));

//		//Version 1
//		if(CreditService.getCreditService().getCredit(this).compareTo(CreditRate.C) < 0){
//			throw new IllegalStateException("CreditRate should be higher then 'C'");
//		}
//
//		//Version 2
//		Rule eligibility = new And(new Rule[]{
//			new Or(new Rule[]{
//					new CreditEvaluate(Operator.MORE, CreditRate.C),
//					new MeritalStatusEvaluate(Operator.EQUALS, "M")
//			}), new AgeEvaluate(Operator.MORE, 23)
//
//		});
//		if(!eligibility.meet(this))
//			throw new IllegalStateException("not eligile");
//
//
//		//Version 3
//		Rule eligibility2 = Evaluate.createTypedJsonObjectMapper().readValue(new FileInputStream("eligibilityRule.json"), Rule.class);
//
//
//		if(!eligibility2.meet(this))
//			throw new IllegalStateException("not eligile");

	}
	@PreUpdate
	public void update() {

		if(getSocialSecurityNumber()!=0){
			checkCreditRate();
			checkLicenseInformation();
		}

	}

	private void checkCreditRate() {
		CreditRate cr = CreditService.getCreditService().getCredit(this);
		setCerditRate(cr.toString());
		if(cr.compareTo(CreditRate.C) >= 0){
			throw new IllegalStateException("CreditRate should be higher then 'C'");
		}
	}

	private void checkLicenseInformation() {
		DMVService ds = DMVService.getService();
		setDriverLicenseNumber(ds.getDriverLicenseNumber(this));
		setDriverLicenseStatus(ds.getDriverLicenseStatus(this));
		if(getDriverLicenseNumber().isEmpty() || getDriverLicenseStatus().isEmpty()) {
			throw new IllegalStateException("Invalid DL");
		}
	}
}