package com.kosta.service.external;


import com.kosta.domain.Policyholder;

public interface NIAService {
/*
3. SYSTEM calls NIA with Customer socialSecurityNumber : int VehicleID : String
4. NIA returns Policyholder previousInsuranceCarrier : String previousInsurancePolicyID : String

 */
    Policyholder getInsuranceInformation(int socialSecurityNumber, String vehicleID, Policyholder policyholder);

}
