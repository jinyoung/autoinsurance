package com.kosta.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(InsureddriverPK.class)
public class Insureddriver {
    private String customerId;
    private String insurancePolicyId;
    private String relationToPolicyholder;
    private Customer customerByCustomerId;
    private Insurancepolicy insurancepolicyByInsurancePolicyId;

    @Id
    @Column(name = "CustomerID")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Id
    @Column(name = "InsurancePolicyID")
    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    @Basic
    @Column(name = "RelationToPolicyholder")
    public String getRelationToPolicyholder() {
        return relationToPolicyholder;
    }

    public void setRelationToPolicyholder(String relationToPolicyholder) {
        this.relationToPolicyholder = relationToPolicyholder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insureddriver that = (Insureddriver) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(insurancePolicyId, that.insurancePolicyId) &&
                Objects.equals(relationToPolicyholder, that.relationToPolicyholder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerId, insurancePolicyId, relationToPolicyholder);
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", nullable = false, insertable =false, updatable =false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
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
