package com.kosta.rules.customer;

import com.kosta.domain.Customer;
import com.kosta.rules.Evaluate;
import com.kosta.rules.Operator;

public class MeritalStatusEvaluate extends Evaluate<Customer, String> {
    public MeritalStatusEvaluate(Operator operator, String compareeValue) {
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
