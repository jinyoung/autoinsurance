package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity @Data
@IdClass(PremiumPaymentPK.class)
public class PremiumPayment {

	@Id
	@ManyToOne
	@JoinColumn(name = "InsurancePolicyID", referencedColumnName = "ID")
	InsurancePolicy insurancePolicy;

	@Id
	private Date paymentDate;

	private String paymentMethod;
	private String accountID;
	private String accountPasscode;
	private BigDecimal paidAmount;

	/**
	 *
	 * @param premiumAmoint Takes InsurancePolicy.insurancePremium as input
	 */
	public void processPayment(double premiumAmoint) {
		// TODO - implement PremiumPayment.processPayment
		throw new UnsupportedOperationException();
	}

}