package com.kosta.rules.customer;

import com.kosta.domain.Customer;
import com.kosta.rules.Evaluate;
import com.kosta.rules.Operator;

import java.util.Calendar;

public class AgeEvaluate extends Evaluate<Customer, Integer> {
    public AgeEvaluate(Operator operator, int compareeValue) {
        super(operator, compareeValue);
    }

    @Override
    public boolean meet(Customer customer) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(customer.getBirthDate());
        int year = cal.get(Calendar.YEAR);
        switch (getOperator()){
            case EQUALS:
                return year == compareeValue;
            case MORE:
                return year < compareeValue;
            case LESS:
                return year < compareeValue;
        }
        throw new IllegalArgumentException("Not Matched Operations");
    }
}
