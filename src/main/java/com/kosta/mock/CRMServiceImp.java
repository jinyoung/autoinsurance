package com.kosta.mock;

import com.kosta.domain.Customer;
import com.kosta.service.external.CRMService;

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
