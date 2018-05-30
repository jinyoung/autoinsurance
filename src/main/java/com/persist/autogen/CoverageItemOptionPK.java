package com.persist.autogen;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CoverageItemOptionPK implements Serializable {
    private String coverageItemInsuranceProductId;
    private String coverageItemId;
    private String id;

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

    @Column(name = "ID")
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoverageItemOptionPK that = (CoverageItemOptionPK) o;
        return Objects.equals(coverageItemInsuranceProductId, that.coverageItemInsuranceProductId) &&
                Objects.equals(coverageItemId, that.coverageItemId) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(coverageItemInsuranceProductId, coverageItemId, id);
    }
}
