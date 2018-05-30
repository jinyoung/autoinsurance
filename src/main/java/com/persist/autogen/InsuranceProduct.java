package com.persist.autogen;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class InsuranceProduct {
    private String id;
    private String name;
    private Collection<CoverageItem> coverageItemsById;

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
        InsuranceProduct that = (InsuranceProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "insuranceProductByInsuranceProductId")
    public Collection<CoverageItem> getCoverageItemsById() {
        return coverageItemsById;
    }

    public void setCoverageItemsById(Collection<CoverageItem> coverageItemsById) {
        this.coverageItemsById = coverageItemsById;
    }
}
