package com.kosta.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String driverLicenseNumber;
    private Integer socialSecurityNumber;
    private String gender;
    private String marritalStatus;
    private String streetAddress;
    private String aptUnitNumber;
    private String city;
    private String state;
    private String zipcode;
    private String cerditRate;
    private String driverLicenseStatus;
    private String highestEduLevel;
    private String accidentHistory;
    private String emailAddress;
    private String healthInsurance;
    private String previousInsuranceCarrier;
    private String previousInsurancePolicyId;
    private String discriminator;
    private Collection<Insureddriver> insureddriversById;
    private Collection<Vehicle> vehiclesById;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "BirthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "DriverLicenseNumber")
    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    @Basic
    @Column(name = "SocialSecurityNumber")
    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "MarritalStatus")
    public String getMarritalStatus() {
        return marritalStatus;
    }

    public void setMarritalStatus(String marritalStatus) {
        this.marritalStatus = marritalStatus;
    }

    @Basic
    @Column(name = "StreetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "AptUnitNumber")
    public String getAptUnitNumber() {
        return aptUnitNumber;
    }

    public void setAptUnitNumber(String aptUnitNumber) {
        this.aptUnitNumber = aptUnitNumber;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "CerditRate")
    public String getCerditRate() {
        return cerditRate;
    }

    public void setCerditRate(String cerditRate) {
        this.cerditRate = cerditRate;
    }

    @Basic
    @Column(name = "DriverLicenseStatus")
    public String getDriverLicenseStatus() {
        return driverLicenseStatus;
    }

    public void setDriverLicenseStatus(String driverLicenseStatus) {
        this.driverLicenseStatus = driverLicenseStatus;
    }

    @Basic
    @Column(name = "HighestEduLevel")
    public String getHighestEduLevel() {
        return highestEduLevel;
    }

    public void setHighestEduLevel(String highestEduLevel) {
        this.highestEduLevel = highestEduLevel;
    }

    @Basic
    @Column(name = "AccidentHistory")
    public String getAccidentHistory() {
        return accidentHistory;
    }

    public void setAccidentHistory(String accidentHistory) {
        this.accidentHistory = accidentHistory;
    }

    @Basic
    @Column(name = "EmailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "HealthInsurance")
    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    @Basic
    @Column(name = "PreviousInsuranceCarrier")
    public String getPreviousInsuranceCarrier() {
        return previousInsuranceCarrier;
    }

    public void setPreviousInsuranceCarrier(String previousInsuranceCarrier) {
        this.previousInsuranceCarrier = previousInsuranceCarrier;
    }

    @Basic
    @Column(name = "PreviousInsurancePolicyID")
    public String getPreviousInsurancePolicyId() {
        return previousInsurancePolicyId;
    }

    public void setPreviousInsurancePolicyId(String previousInsurancePolicyId) {
        this.previousInsurancePolicyId = previousInsurancePolicyId;
    }

    @Basic
    @Column(name = "Discriminator")
    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(birthDate, customer.birthDate) &&
                Objects.equals(driverLicenseNumber, customer.driverLicenseNumber) &&
                Objects.equals(socialSecurityNumber, customer.socialSecurityNumber) &&
                Objects.equals(gender, customer.gender) &&
                Objects.equals(marritalStatus, customer.marritalStatus) &&
                Objects.equals(streetAddress, customer.streetAddress) &&
                Objects.equals(aptUnitNumber, customer.aptUnitNumber) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(state, customer.state) &&
                Objects.equals(zipcode, customer.zipcode) &&
                Objects.equals(cerditRate, customer.cerditRate) &&
                Objects.equals(driverLicenseStatus, customer.driverLicenseStatus) &&
                Objects.equals(highestEduLevel, customer.highestEduLevel) &&
                Objects.equals(accidentHistory, customer.accidentHistory) &&
                Objects.equals(emailAddress, customer.emailAddress) &&
                Objects.equals(healthInsurance, customer.healthInsurance) &&
                Objects.equals(previousInsuranceCarrier, customer.previousInsuranceCarrier) &&
                Objects.equals(previousInsurancePolicyId, customer.previousInsurancePolicyId) &&
                Objects.equals(discriminator, customer.discriminator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, birthDate, driverLicenseNumber, socialSecurityNumber, gender, marritalStatus, streetAddress, aptUnitNumber, city, state, zipcode, cerditRate, driverLicenseStatus, highestEduLevel, accidentHistory, emailAddress, healthInsurance, previousInsuranceCarrier, previousInsurancePolicyId, discriminator);
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Insureddriver> getInsureddriversById() {
        return insureddriversById;
    }

    public void setInsureddriversById(Collection<Insureddriver> insureddriversById) {
        this.insureddriversById = insureddriversById;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Vehicle> getVehiclesById() {
        return vehiclesById;
    }

    public void setVehiclesById(Collection<Vehicle> vehiclesById) {
        this.vehiclesById = vehiclesById;
    }
}
