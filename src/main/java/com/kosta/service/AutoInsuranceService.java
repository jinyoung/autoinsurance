package com.kosta.service;

import com.kosta.domain.InsurancePolicy;

public interface AutoInsuranceService {
    //InsurancePolicy evaluateEligibilityforInsurancePolicy(InsurancePolicy insurancePolicy);

    InsurancePolicy evaluateEligibilityforInsurancePolicy(long id);
}
