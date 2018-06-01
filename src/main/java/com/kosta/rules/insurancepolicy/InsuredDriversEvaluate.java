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
                    insuredDriver.getRelationToPolicyholder().equals(compareeValue);
                    return true;
                case EMPTY:
                    insuredDriver.getRelationToPolicyholder().isEmpty();
                    return true;
            }
        }
        throw new IllegalArgumentException();
    }
}
