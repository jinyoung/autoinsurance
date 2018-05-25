package com.kosta.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(PremiumpaymentPK.class)
public class Premiumpayment {
    private String insurancePolicyId;
    private Date paymentDate;
    private String paymentMethod;
    private String accountId;
    private String accountPasscode;
    private BigDecimal paidAmount;
    private Insurancepolicy insurancepolicyByInsurancePolicyId;

    @Id
    @Column(name = "InsurancePolicyID")
    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    @Id
    @Column(name = "PaymentDate")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "PaymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "AccountID")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "AccountPasscode")
    public String getAccountPasscode() {
        return accountPasscode;
    }

    public void setAccountPasscode(String accountPasscode) {
        this.accountPasscode = accountPasscode;
    }

    @Basic
    @Column(name = "PaidAmount")
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premiumpayment that = (Premiumpayment) o;
        return Objects.equals(insurancePolicyId, that.insurancePolicyId) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(accountPasscode, that.accountPasscode) &&
                Objects.equals(paidAmount, that.paidAmount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insurancePolicyId, paymentDate, paymentMethod, accountId, accountPasscode, paidAmount);
    }

    @ManyToOne
    @JoinColumn(name = "InsurancePolicyID", referencedColumnName = "ID", nullable = false, insertable =false, updatable =false)
    public Insurancepolicy getInsurancepolicyByInsurancePolicyId() {
        return insurancepolicyByInsurancePolicyId;
    }

    public void setInsurancepolicyByInsurancePolicyId(Insurancepolicy insurancepolicyByInsurancePolicyId) {
        this.insurancepolicyByInsurancePolicyId = insurancepolicyByInsurancePolicyId;
    }
}
