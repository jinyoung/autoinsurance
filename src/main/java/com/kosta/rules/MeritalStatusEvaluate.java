package com.kosta.rules;

import com.kosta.domain.Customer;

public class MeritalStatusEvaluate extends Evaluate {
    public MeritalStatusEvaluate(Operator operator, Object compareeValue) {
        super(operator, compareeValue);
    }

    @Override
    public boolean meet(Customer customer) {

        switch (getOperator()){
            case EQUALS:
                return customer.getMarritalStatus().equals(compareeValue);
        }
        throw new IllegalArgumentException("Not Matched Operations");
    }
}
