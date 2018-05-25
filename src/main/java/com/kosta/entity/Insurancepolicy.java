package com.kosta.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Insurancepolicy {
    private String id;
    private String vehicleId;
    private String state;
    private Date coveageStartDate;
    private BigDecimal insurancePremium;
    private String billPlan;
    private byte[] signature;
    private Vehicle vehicleByVehicleId;
    private Collection<Insureddriver> insureddriversById;
    private Collection<Premiumpayment> premiumpaymentsById;
    private Collection<Selectedoption> selectedoptionsById;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "VehicleID")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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
    @Column(name = "CoveageStartDate")
    public Date getCoveageStartDate() {
        return coveageStartDate;
    }

    public void setCoveageStartDate(Date coveageStartDate) {
        this.coveageStartDate = coveageStartDate;
    }

    @Basic
    @Column(name = "InsurancePremium")
    public BigDecimal getInsurancePremium() {
        return insurancePremium;
    }

    public void setInsurancePremium(BigDecimal insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    @Basic
    @Column(name = "BillPlan")
    public String getBillPlan() {
        return billPlan;
    }

    public void setBillPlan(String billPlan) {
        this.billPlan = billPlan;
    }

    @Basic
    @Column(name = "Signature")
    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurancepolicy that = (Insurancepolicy) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(state, that.state) &&
                Objects.equals(coveageStartDate, that.coveageStartDate) &&
                Objects.equals(insurancePremium, that.insurancePremium) &&
                Objects.equals(billPlan, that.billPlan) &&
                Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, vehicleId, state, coveageStartDate, insurancePremium, billPlan);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "VehicleID", referencedColumnName = "ID", nullable = false, insertable =false, updatable =false)
    public Vehicle getVehicleByVehicleId() {
        return vehicleByVehicleId;
    }

    public void setVehicleByVehicleId(Vehicle vehicleByVehicleId) {
        this.vehicleByVehicleId = vehicleByVehicleId;
    }

    @OneToMany(mappedBy = "insurancepolicyByInsurancePolicyId")
    public Collection<Insureddriver> getInsureddriversById() {
        return insureddriversById;
    }

    public void setInsureddriversById(Collection<Insureddriver> insureddriversById) {
        this.insureddriversById = insureddriversById;
    }

    @OneToMany(mappedBy = "insurancepolicyByInsurancePolicyId")
    public Collection<Premiumpayment> getPremiumpaymentsById() {
        return premiumpaymentsById;
    }

    public void setPremiumpaymentsById(Collection<Premiumpayment> premiumpaymentsById) {
        this.premiumpaymentsById = premiumpaymentsById;
    }

    @OneToMany(mappedBy = "insurancepolicyByInsurancePolicyId")
    public Collection<Selectedoption> getSelectedoptionsById() {
        return selectedoptionsById;
    }

    public void setSelectedoptionsById(Collection<Selectedoption> selectedoptionsById) {
        this.selectedoptionsById = selectedoptionsById;
    }
}
