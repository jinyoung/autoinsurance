package com.kosta.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SelectedoptionPK implements Serializable {
    private String insurancePolicyId;
    private String coverageItemInsuranceProductId;
    private String coverageItemId;

    @Column(name = "InsurancePolicyID")
    @Id
    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    @Column(name = "CoverageItemInsuranceProductID")
    @Id
    public String getCoverageItemInsuranceProductId() {
        return coverageItemInsuranceProductId;
    }

    public void setCoverageItemInsuranceProductId(String coverageItemInsuranceProductId) {
        this.coverageItemInsuranceProductId = coverageItemInsuranceProductId;
    }

    @Column(name = "CoverageItemID")
    @Id
    public String getCoverageItemId() {
        return coverageItemId;
    }

    public void setCoverageItemId(String coverageItemId) {
        this.coverageItemId = coverageItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedoptionPK that = (SelectedoptionPK) o;
        return Objects.equals(insurancePolicyId, that.insurancePolicyId) &&
                Objects.equals(coverageItemInsuranceProductId, that.coverageItemInsuranceProductId) &&
                Objects.equals(coverageItemId, that.coverageItemId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insurancePolicyId, coverageItemInsuranceProductId, coverageItemId);
    }
}
