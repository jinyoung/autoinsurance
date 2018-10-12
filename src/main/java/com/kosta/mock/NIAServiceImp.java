package com.kosta.mock;

import com.kosta.domain.Customer;
import com.kosta.domain.PolicyholderInformation;
import com.kosta.service.external.NIAService;

public class NIAServiceImp implements NIAService {

    /*
3. SYSTEM calls NIA with Customer socialSecurityNumber : int VehicleID : String
4. NIA returns PolicyholderInformation previousInsuranceCarrier : String previousInsurancePolicyID : String

 */

    @Override
    public PolicyholderInformation getInsuranceInformation(Customer customer) {
        PolicyholderInformation information = customer.getPolicyholderInformation();
        information.setPreviousInsuranceCarrier("previous");
        information.setPreviousInsurancePolicyID("previous_policy");
        return information;
    }
}
