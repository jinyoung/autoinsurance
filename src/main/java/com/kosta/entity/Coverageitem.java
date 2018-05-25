package com.kosta.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@IdClass(CoverageitemPK.class)
public class Coverageitem {
    private String insuranceProductId;
    private String id;
    private String name;
    private Insuranceproduct insuranceproductByInsuranceProductId;
    private Collection<Coverageitemoption> coverageitemoptions;
    private Collection<Selectedoption> selectedoptions;

    @Id
    @Column(name = "InsuranceProductID")
    public String getInsuranceProductId() {
        return insuranceProductId;
    }

    public void setInsuranceProductId(String insuranceProductId) {
        this.insuranceProductId = insuranceProductId;
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
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coverageitem that = (Coverageitem) o;
        return Objects.equals(insuranceProductId, that.insuranceProductId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insuranceProductId, id, name);
    }

    @ManyToOne
    @JoinColumn(name = "InsuranceProductID", referencedColumnName = "ID", nullable = false, insertable =false, updatable =false)
    public Insuranceproduct getInsuranceproductByInsuranceProductId() {
        return insuranceproductByInsuranceProductId;
    }

    public void setInsuranceproductByInsuranceProductId(Insuranceproduct insuranceproductByInsuranceProductId) {
        this.insuranceproductByInsuranceProductId = insuranceproductByInsuranceProductId;
    }

    @OneToMany(mappedBy = "coverageitem")
    public Collection<Coverageitemoption> getCoverageitemoptions() {
        return coverageitemoptions;
    }

    public void setCoverageitemoptions(Collection<Coverageitemoption> coverageitemoptions) {
        this.coverageitemoptions = coverageitemoptions;
    }

    @OneToMany(mappedBy = "coverageitem")
    public Collection<Selectedoption> getSelectedoptions() {
        return selectedoptions;
    }

    public void setSelectedoptions(Collection<Selectedoption> selectedoptions) {
        this.selectedoptions = selectedoptions;
    }
}
