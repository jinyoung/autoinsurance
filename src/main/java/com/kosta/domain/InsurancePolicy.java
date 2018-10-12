package com.kosta.domain;

import com.kosta.AutoInsuranceApplication;
import com.kosta.service.external.NIAService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity @Data @Slf4j
public class InsurancePolicy {

	@Id @GeneratedValue
	private long id;
	private String state;
	private Date coveageStartDate;
	private BigDecimal insurancePremium;
	private String billPlan;
	private char[] signature;

	@OneToMany(mappedBy = "insurancePolicy")
	private List<PremiumPayment> premiumPayment;

	@ManyToOne
	@JoinColumn(name = "policyholder_id")
	private Customer policyholder;

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	@ManyToMany
	@JoinTable(
			name = "insurance_policy_coverage_item_option",
			inverseJoinColumns = @JoinColumn(name = "coverage_item_optionid"),
			joinColumns = @JoinColumn(name = "insurance_policy_id")
	)
	private Collection<CoverageItemOption> coverageItemOptions;

	@OneToMany(mappedBy = "insurancePolicy")
	List<InsuredDriver> insuredDrivers;



	/**
	 * Returns .InsurancePolicy.ID
	 * @param CustomerID
	 * @param VehicleID
	 */
	public String createPolicy(int CustomerID, String VehicleID) {
		// TODO - implement InsurancePolicy.createPolicy
		throw new UnsupportedOperationException();
	}

	@PreUpdate
	public void updatePolicy() {

		switch (state){
			case "Passed Eligibility Test":

				log.info(policyholder.getPolicyholderInformation().toString());
				if(StringUtils.isEmpty(policyholder.getPolicyholderInformation().getEmailAddress())||
						StringUtils.isEmpty(policyholder.getPolicyholderInformation().getHealthInsurance().isEmpty())) {
					throw new IllegalStateException("Please enter the email address and health insurance");
				}
				NIAService niaService = AutoInsuranceApplication.applicationContext.getBean(NIAService.class);
				niaService.getInsuranceInformation(policyholder.getSocialSecurityNumber(),
						vehicle.getID(),policyholder.getPolicyholderInformation());
				/*2. Customer enters PolicyholderInformation emailAddress : String healthInsurance : String
3. SYSTEM calls NIA with CustomersocialSecurityNumber : intVehicleID : String
4. NIA returnsPolicyholder previousInsuranceCarrier : StringpreviousInsurancePolicyID : String
*/

		}

	}

	public void producePolicyDocument() {
		// TODO - implement InsurancePolicy.producePolicyDocument
		throw new UnsupportedOperationException();
	}

}