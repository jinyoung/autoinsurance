package com.persist.autogen;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class InsurancePolicy {
    private String id;
    private String vehicleId;
    private String state;
    private Date coveageStartDate;
    private BigDecimal insurancePremium;
    private String billPlan;
    private byte[] signature;
    private Vehicle vehicleByVehicleId;
    private Collection<InsuredDriver> insuredDriversById;
    private Collection<PremiumPayment> premiumPaymentsById;
    private Collection<SelectedOption> selectedOptionsById;

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
        InsurancePolicy that = (InsurancePolicy) o;
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
    @JoinColumn(name = "VehicleID", referencedColumnName = "ID", nullable = false)
    public Vehicle getVehicleByVehicleId() {
        return vehicleByVehicleId;
    }

    public void setVehicleByVehicleId(Vehicle vehicleByVehicleId) {
        this.vehicleByVehicleId = vehicleByVehicleId;
    }

    @OneToMany(mappedBy = "insurancePolicyByInsurancePolicyId")
    public Collection<InsuredDriver> getInsuredDriversById() {
        return insuredDriversById;
    }

    public void setInsuredDriversById(Collection<InsuredDriver> insuredDriversById) {
        this.insuredDriversById = insuredDriversById;
    }

    @OneToMany(mappedBy = "insurancePolicyByInsurancePolicyId")
    public Collection<PremiumPayment> getPremiumPaymentsById() {
        return premiumPaymentsById;
    }

    public void setPremiumPaymentsById(Collection<PremiumPayment> premiumPaymentsById) {
        this.premiumPaymentsById = premiumPaymentsById;
    }

    @OneToMany(mappedBy = "insurancePolicyByInsurancePolicyId")
    public Collection<SelectedOption> getSelectedOptionsById() {
        return selectedOptionsById;
    }

    public void setSelectedOptionsById(Collection<SelectedOption> selectedOptionsById) {
        this.selectedOptionsById = selectedOptionsById;
    }
}
