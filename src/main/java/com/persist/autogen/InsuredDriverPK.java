package com.persist.autogen;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class InsuredDriverPK implements Serializable {
    private String customerId;
    private String insurancePolicyId;

    @Column(name = "CustomerID")
    @Id
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "InsurancePolicyID")
    @Id
    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuredDriverPK that = (InsuredDriverPK) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(insurancePolicyId, that.insurancePolicyId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerId, insurancePolicyId);
    }
}
