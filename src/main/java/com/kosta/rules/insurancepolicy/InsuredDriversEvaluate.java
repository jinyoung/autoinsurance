package com.kosta.rules.insurancepolicy;

import com.kosta.domain.InsurancePolicy;
import com.kosta.domain.InsuredDriver;
import com.kosta.rules.Evaluate;
import com.kosta.rules.Operator;

import java.util.List;

public class InsuredDriversEvaluate extends Evaluate<InsurancePolicy, String> {

    public InsuredDriversEvaluate(Operator operator, String compareeValue) {
        super(operator, compareeValue);
    }

    @Override
    public boolean meet(InsurancePolicy insurancePolicy) {
        List<InsuredDriver> insuredDrivers = insurancePolicy.getInsuredDrivers();
        for(InsuredDriver insuredDriver : insuredDrivers) {
            switch (operator) {
                case EQUALS:
                    return insuredDriver.getRelationToPolicyholder().equals(compareeValue);
                case EMPTY:
                    return insuredDriver.getRelationToPolicyholder().isEmpty();
                case NOT_EMPTY:
                    return !insuredDriver.getRelationToPolicyholder().isEmpty();
            }
        }
        throw new IllegalArgumentException();
    }
}
