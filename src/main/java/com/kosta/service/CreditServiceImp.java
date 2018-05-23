package com.kosta.service;

import com.kosta.domain.Policyholder;

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
