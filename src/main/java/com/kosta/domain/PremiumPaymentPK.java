package com.kosta.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Data
public class PremiumPaymentPK implements Serializable {
    InsurancePolicy insurancePolicy;
    private Date paymentDate;
}
