package com.kosta.domain;

import com.kosta.AutoInsuranceApplication;
import com.kosta.service.external.DMVService;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity @Data
public class Policyholder {

	@Id @GeneratedValue
	@Column(name = "policyholder_id")
	private long id;

	@OneToOne
	@JoinColumn(referencedColumnName = "customer_id")
	private Customer customer;
	private String driverLicenseStatus;
	private String highestEduLevel;
	private String accidentHistory;
	private String emailAddress;
	private String healthInsurance;
	private String previousInsuranceCarrier;
	private String previousInsurancePolicyID;

	@OneToMany(mappedBy = "policyholder")
	private List<InsurancePolicy> insurancePolicy;

	public void registerVehicleToInsure(){

	}

	@PrePersist
	public void updatePolicyholder() {

		if(customer.getSocialSecurityNumber()!=0){
			checkLicenseInformation();
		} else {
			throw new IllegalStateException("not field social security number");
		}



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
		DMVService ds = AutoInsuranceApplication.applicationContext.getBean(DMVService.class);
		customer.setDriverLicenseNumber(ds.getDriverLicenseNumber(this));
		setDriverLicenseStatus(ds.getDriverLicenseStatus(this));
		if(customer.getDriverLicenseNumber().isEmpty() || getDriverLicenseStatus().isEmpty()) {
			throw new IllegalStateException("Invalid DL");
		}
	}
}