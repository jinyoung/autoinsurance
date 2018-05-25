package com.kosta.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CoverageitemPK implements Serializable {
    private String insuranceProductId;
    private String id;

    @Column(name = "InsuranceProductID")
    @Id
    public String getInsuranceProductId() {
        return insuranceProductId;
    }

    public void setInsuranceProductId(String insuranceProductId) {
        this.insuranceProductId = insuranceProductId;
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
        CoverageitemPK that = (CoverageitemPK) o;
        return Objects.equals(insuranceProductId, that.insuranceProductId) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insuranceProductId, id);
    }
}
