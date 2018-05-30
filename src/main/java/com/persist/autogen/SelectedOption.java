package com.persist.autogen;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(SelectedOptionPK.class)
public class SelectedOption {
    private String insurancePolicyId;
    private String coverageItemInsuranceProductId;
    private String coverageItemId;
    private BigDecimal value;
    private InsurancePolicy insurancePolicyByInsurancePolicyId;
    private CoverageItem coverageItem;

    @Id
    @Column(name = "InsurancePolicyID")
    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    @Id
    @Column(name = "CoverageItemInsuranceProductID")
    public String getCoverageItemInsuranceProductId() {
        return coverageItemInsuranceProductId;
    }

    public void setCoverageItemInsuranceProductId(String coverageItemInsuranceProductId) {
        this.coverageItemInsuranceProductId = coverageItemInsuranceProductId;
    }

    @Id
    @Column(name = "CoverageItemID")
    public String getCoverageItemId() {
        return coverageItemId;
    }

    public void setCoverageItemId(String coverageItemId) {
        this.coverageItemId = coverageItemId;
    }

    @Basic
    @Column(name = "Value")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedOption that = (SelectedOption) o;
        return Objects.equals(insurancePolicyId, that.insurancePolicyId) &&
                Objects.equals(coverageItemInsuranceProductId, that.coverageItemInsuranceProductId) &&
                Objects.equals(coverageItemId, that.coverageItemId) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insurancePolicyId, coverageItemInsuranceProductId, coverageItemId, value);
    }

    @ManyToOne
    @JoinColumn(name = "InsurancePolicyID", referencedColumnName = "ID", nullable = false)
    public InsurancePolicy getInsurancePolicyByInsurancePolicyId() {
        return insurancePolicyByInsurancePolicyId;
    }

    public void setInsurancePolicyByInsurancePolicyId(InsurancePolicy insurancePolicyByInsurancePolicyId) {
        this.insurancePolicyByInsurancePolicyId = insurancePolicyByInsurancePolicyId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "CoverageItemInsuranceProductID", referencedColumnName = "InsuranceProductID", nullable = false), @JoinColumn(name = "CoverageItemID", referencedColumnName = "ID", nullable = false)})
    public CoverageItem getCoverageItem() {
        return coverageItem;
    }

    public void setCoverageItem(CoverageItem coverageItem) {
        this.coverageItem = coverageItem;
    }
}
