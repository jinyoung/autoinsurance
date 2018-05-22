package com.kosta.service;

import com.kosta.domain.Policyholder;

public class CreditService {

    private static CreditService creditService;

    public static CreditService getCreditService() {
        if(creditService == null)
            creditService =  new CreditService();

        return creditService;
    }

    public CreditRate getCredit(Policyholder p) {
        //This is mock Service
        return CreditRate.A;
    }
}
