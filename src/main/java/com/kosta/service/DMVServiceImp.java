package com.kosta.service;

import com.kosta.domain.Customer;
import com.kosta.domain.Policyholder;

public class DMVServiceImp implements DMVService {

    @Override
    public String getDriverLicenseNumber(Customer customer) {
        //This is mock
        return customer.getFirstName();
    }

    @Override
    public String getDriverLicenseStatus(Policyholder policyholder) {
        //this is mock
        return "G";
    }


}
