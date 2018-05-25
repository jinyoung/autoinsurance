package com.kosta.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Insuranceproduct {
    private String id;
    private String name;
    private Collection<Coverageitem> coverageitemsById;

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
        Insuranceproduct that = (Insuranceproduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "insuranceproductByInsuranceProductId")
    public Collection<Coverageitem> getCoverageitemsById() {
        return coverageitemsById;
    }

    public void setCoverageitemsById(Collection<Coverageitem> coverageitemsById) {
        this.coverageitemsById = coverageitemsById;
    }
}
