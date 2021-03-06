package com.kosta.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import java.io.Serializable;

@Embeddable @Data
public class PolicyholderInformation implements Serializable {

	private String driverLicenseStatus;
	private String highestEduLevel;
	private String accidentHistory;
	private String emailAddress;
	private String healthInsurance;
	private String previousInsuranceCarrier;
	private String previousInsurancePolicyID;

	public void registerVehicleToInsure(){

	}

	@PrePersist
	public void updatePolicyholder() {

//		if(!customer.getSocialSecurityNumber().isEmpty()){
//			checkLicenseInformation();
//		} else {
//			throw new IllegalStateException("not field social security number");
//		}



//		//Version 1
//		if(CreditServiceImp.getCreditServiceImp().getCredit(this).compareTo(CreditRate.C) < 0){
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

	private void checkLicenseInformation() {
		//Spring Version
//		DMVService ds = AutoInsuranceApplication.applicationContext.getBean(DMVService.class);
//		customer.setDriverLicenseNumber(ds.getDriverLicenseNumber(this));
//		setDriverLicenseStatus(ds.getDriverLicenseStatus(this));
//		if(customer.getDriverLicenseNumber().isEmpty() || getDriverLicenseStatus().isEmpty()) {
//			throw new IllegalStateException("Invalid DL");
//		}
	}
}