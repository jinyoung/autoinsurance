package com.persist.autogen;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@IdClass(CoverageItemPK.class)
public class CoverageItem {
    private String insuranceProductId;
    private String id;
    private String name;
    private InsuranceProduct insuranceProductByInsuranceProductId;
    private Collection<CoverageItemOption> coverageItemOptions;
    private Collection<SelectedOption> selectedOptions;

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
        CoverageItem that = (CoverageItem) o;
        return Objects.equals(insuranceProductId, that.insuranceProductId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insuranceProductId, id, name);
    }

    @ManyToOne
    @JoinColumn(name = "InsuranceProductID", referencedColumnName = "ID", nullable = false)
    public InsuranceProduct getInsuranceProductByInsuranceProductId() {
        return insuranceProductByInsuranceProductId;
    }

    public void setInsuranceProductByInsuranceProductId(InsuranceProduct insuranceProductByInsuranceProductId) {
        this.insuranceProductByInsuranceProductId = insuranceProductByInsuranceProductId;
    }

    @OneToMany(mappedBy = "coverageItem")
    public Collection<CoverageItemOption> getCoverageItemOptions() {
        return coverageItemOptions;
    }

    public void setCoverageItemOptions(Collection<CoverageItemOption> coverageItemOptions) {
        this.coverageItemOptions = coverageItemOptions;
    }

    @OneToMany(mappedBy = "coverageItem")
    public Collection<SelectedOption> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(Collection<SelectedOption> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}
