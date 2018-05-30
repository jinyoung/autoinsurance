package com.persist.autogen;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(CoverageItemOptionPK.class)
public class CoverageItemOption {
    private String coverageItemInsuranceProductId;
    private String coverageItemId;
    private String id;
    private BigDecimal value;
    private CoverageItem coverageItem;

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

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        CoverageItemOption that = (CoverageItemOption) o;
        return Objects.equals(coverageItemInsuranceProductId, that.coverageItemInsuranceProductId) &&
                Objects.equals(coverageItemId, that.coverageItemId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(coverageItemInsuranceProductId, coverageItemId, id, value);
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
