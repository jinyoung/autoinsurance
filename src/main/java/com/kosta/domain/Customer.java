package com.kosta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kosta.AutoInsuranceApplication;
import com.kosta.service.CreditRate;
import com.kosta.service.external.CRMService;
import com.kosta.service.external.CreditService;
import com.kosta.service.external.NIAService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity @Data @Slf4j
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

	@Transient @JsonIgnore
	CRMService crmService;

	@Transient @JsonIgnore
	CreditService creditService;

	public Customer() {
		crmService = AutoInsuranceApplication.applicationContext.getBean(CRMService.class);
		creditService = AutoInsuranceApplication.applicationContext.getBean(CreditService.class);
		policyholderInformation = new PolicyholderInformation();
	}


	@JsonIgnore
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

	@Embedded
	private PolicyholderInformation policyholderInformation;

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<InsuredDriver> insuredDrivers;

	@JsonIgnore
	@OneToMany(mappedBy = "policyholder")
	private List<InsurancePolicy> insurancePolicy;

	/**
	 * Returns Customer.ID
	 */
	@PrePersist
	public void registerCustomer() throws IllegalStateException {
		setId(crmService.getCustomerID(this));
	}


	@PostUpdate
	private void checkCreditRateByCreditService() {
		if(!StringUtils.isEmpty(getSocialSecurityNumber())) {
			CreditRate cr = creditService.getCredit(this);
			setCreditRate(cr.toString());
			if (cr.compareTo(CreditRate.C) >= 0) {
				throw new IllegalStateException("CreditRate should be higher then 'C'");
			}
		}
    }

    @PreUpdate
    private void updatePreviousInformationByNiaService(){
		if(!StringUtils.isEmpty(policyholderInformation.getEmailAddress())
				&&!StringUtils.isEmpty(policyholderInformation.getHealthInsurance())) {
			NIAService niaService = AutoInsuranceApplication.applicationContext.getBean(NIAService.class);
			niaService.getInsuranceInformation(this);
		}
	}


}