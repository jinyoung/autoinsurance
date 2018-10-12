package com.kosta.service.external;


import com.kosta.domain.Customer;
import com.kosta.domain.PolicyholderInformation;

public interface NIAService {
/*
3. SYSTEM calls NIA with Customer socialSecurityNumber : int VehicleID : String
4. NIA returns PolicyholderInformation previousInsuranceCarrier : String previousInsurancePolicyID : String

 */
    PolicyholderInformation getInsuranceInformation(Customer customer);

}
