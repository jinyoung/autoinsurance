package com.kosta.mock;

import com.kosta.domain.Policyholder;
import com.kosta.service.CreditRate;
import com.kosta.service.CreditService;

public class CreditServiceImp implements CreditService {

    public CreditRate getCredit(Policyholder p) {
        //This is mock Service
        if(p.getSocialSecurityNumber()%2==0) {
            return CreditRate.A;
        } else {
            return CreditRate.D;
        }
    }
}
