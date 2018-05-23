package com.kosta.service;

import com.kosta.domain.Customer;

public class CRMServiceImp implements CRMService {

    private static CRMService crmService;

    public static CRMService getService() {
        if(crmService == null)
            crmService =  new CRMServiceImp();

        return crmService;
    }

    @Override
    public String getCustomerID(Customer customer) {
        //This is mock
        return customer.getFirstName()+customer.getLastName();
    }
}
