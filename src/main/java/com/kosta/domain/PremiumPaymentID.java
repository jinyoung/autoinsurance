package com.kosta.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PremiumPaymentID implements Serializable {
    InsurancePolicy insurancePolicy;
    private Date paymentDate;
}
