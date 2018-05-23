package com.kosta.rules;

import com.kosta.AutoInsuranceApplication;
import com.kosta.domain.Customer;
import com.kosta.domain.Policyholder;
import com.kosta.service.CreditRate;
import com.kosta.service.CreditService;

public class CreditEvaluate extends Evaluate {

    public CreditEvaluate(Operator operator, Object compareeValue) {
        super(operator, compareeValue);
    }

    @Override
    public boolean meet(Customer customer) {

        CreditRate cr = AutoInsuranceApplication.applicationContext.getBean(CreditService.class).getCredit((Policyholder)customer);
        int compareResult = cr.compareTo((CreditRate)compareeValue);
        switch (getOperator()){
            case EQUALS:
                return compareResult == 0;
            case MORE:
                return compareResult > 0;
            case LESS:
                return compareResult < 0;
        }
        throw new IllegalArgumentException("Not Matched Operations");
    }
}
