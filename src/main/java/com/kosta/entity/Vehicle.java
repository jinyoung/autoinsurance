package com.kosta.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vehicle {
    private String id;
    private String customerId;
    private String type;
    private String make;
    private String model;
    private Date year;
    private String primaryUsage;
    private String parkingZipcode;
    private String ownership;
    private Collection<Insurancepolicy> insurancepoliciesById;
    private Customer customerByCustomerId;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CustomerID")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "Model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "Year")
    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Basic
    @Column(name = "PrimaryUsage")
    public String getPrimaryUsage() {
        return primaryUsage;
    }

    public void setPrimaryUsage(String primaryUsage) {
        this.primaryUsage = primaryUsage;
    }

    @Basic
    @Column(name = "ParkingZipcode")
    public String getParkingZipcode() {
        return parkingZipcode;
    }

    public void setParkingZipcode(String parkingZipcode) {
        this.parkingZipcode = parkingZipcode;
    }

    @Basic
    @Column(name = "Ownership")
    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) &&
                Objects.equals(customerId, vehicle.customerId) &&
                Objects.equals(type, vehicle.type) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(year, vehicle.year) &&
                Objects.equals(primaryUsage, vehicle.primaryUsage) &&
                Objects.equals(parkingZipcode, vehicle.parkingZipcode) &&
                Objects.equals(ownership, vehicle.ownership);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerId, type, make, model, year, primaryUsage, parkingZipcode, ownership);
    }

    @OneToMany(mappedBy = "vehicleByVehicleId")
    public Collection<Insurancepolicy> getInsurancepoliciesById() {
        return insurancepoliciesById;
    }

    public void setInsurancepoliciesById(Collection<Insurancepolicy> insurancepoliciesById) {
        this.insurancepoliciesById = insurancepoliciesById;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", nullable = false, insertable =false, updatable =false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
