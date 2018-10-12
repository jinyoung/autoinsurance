package com.kosta.mock;

import com.kosta.domain.InsurancePolicy;
import com.kosta.repository.InsurancePolicyRepository;
import com.kosta.rules.And;
import com.kosta.rules.Operator;
import com.kosta.rules.Rule;
import com.kosta.rules.insurancepolicy.InsuredDriversEvaluate;
import com.kosta.service.AutoInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoInsuranceServiceImp implements AutoInsuranceService {

    private final InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    public AutoInsuranceServiceImp(InsurancePolicyRepository insurancePolicyRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    @Override
    public InsurancePolicy evaluateEligibilityforInsurancePolicy(InsurancePolicy insurancePolicy) {

        Rule<InsurancePolicy> rule = new And<>(new Rule[]{
                new InsuredDriversEvaluate(Operator.EMPTY, "")
        });

        if(!rule.meet(insurancePolicy)){
            insurancePolicy.setState("Rejected due to Non-Eligibility");
            insurancePolicyRepository.save(insurancePolicy);
            throw new IllegalStateException("Rejected due to Non-Eligibility");
        } else {
            insurancePolicy.setState("Passed Eligibility Test");
            return insurancePolicyRepository.save(insurancePolicy);
        }
    }
}
