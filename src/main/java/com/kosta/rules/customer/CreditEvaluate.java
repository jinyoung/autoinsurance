package com.kosta.rules.customer;

import com.kosta.AutoInsuranceApplication;
import com.kosta.domain.Customer;
import com.kosta.rules.Evaluate;
import com.kosta.rules.Operator;
import com.kosta.service.CreditRate;
import com.kosta.service.external.CreditService;

public class CreditEvaluate extends Evaluate<Customer, CreditRate> {

    public CreditEvaluate(Operator operator, CreditRate compareeValue) {
        super(operator, compareeValue);
    }

    @Override
    public boolean meet(Customer customer) {

        CreditRate cr = AutoInsuranceApplication.applicationContext.getBean(CreditService.class).getCredit(customer);
        int compareResult = cr.compareTo(compareeValue);
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
