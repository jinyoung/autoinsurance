package com.kosta.service;

import com.kosta.domain.Customer;
import com.kosta.domain.Policyholder;

public class DMVService {

    private static DMVService dmvService;

    public static DMVService getService() {
        if(dmvService == null)
            dmvService =  new DMVService();

        return dmvService;
    }


    public String getDriverLicenseNumber(Customer customer) {
        //This is mock
        return customer.getFirstName();
    }

    public String getDriverLicenseStatus(Policyholder policyholder) {
        //this is mock
        return "G";
    }


}
