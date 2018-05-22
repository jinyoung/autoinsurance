package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity @Data
@IdClass(PremiumPaymentID.class)
public class PremiumPayment {

	@Id
	@OneToOne(targetEntity = InsurancePolicy.class)
	@JoinColumn(name = "InsurancePolicyID")
	InsurancePolicy insurancePolicy;
	private String paymentMethod;
	private String accountID;
	private String accountPasscode;
	private BigDecimal paidAmount;

	@Id
	private Date paymentDate;

	/**
	 *
	 * @param premiumAmoint Takes InsurancePolicy.insurancePremium as input
	 */
	public void processPayment(double premiumAmoint) {
		// TODO - implement PremiumPayment.processPayment
		throw new UnsupportedOperationException();
	}

}