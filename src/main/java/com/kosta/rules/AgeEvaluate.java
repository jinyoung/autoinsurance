package com.kosta.rules;

import com.kosta.domain.Customer;

import java.util.Calendar;

public class AgeEvaluate extends Evaluate {
    public AgeEvaluate(Operator operator, Object compareeValue) {
        super(operator, compareeValue);
    }

    @Override
    public boolean meet(Customer customer) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(customer.getBirthDate());
        int year = cal.get(Calendar.YEAR);
        switch (getOperator()){
            case EQUALS:
                return year == (int)compareeValue;
            case MORE:
                return year < (int)compareeValue;
            case LESS:
                return year < (int)compareeValue;
        }
        throw new IllegalArgumentException("Not Matched Operations");
    }
}
