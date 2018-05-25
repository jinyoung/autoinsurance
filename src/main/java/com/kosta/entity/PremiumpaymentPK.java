package com.kosta.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class PremiumpaymentPK implements Serializable {
    private String insurancePolicyId;
    private Date paymentDate;

    @Column(name = "InsurancePolicyID")
    @Id
    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    @Column(name = "PaymentDate")
    @Id
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremiumpaymentPK that = (PremiumpaymentPK) o;
        return Objects.equals(insurancePolicyId, that.insurancePolicyId) &&
                Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insurancePolicyId, paymentDate);
    }
}
