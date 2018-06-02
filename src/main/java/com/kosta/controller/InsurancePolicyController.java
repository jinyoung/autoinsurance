package com.kosta.controller;

import com.kosta.domain.InsurancePolicy;
import com.kosta.service.AutoInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurence-policy-controller")
public class InsurancePolicyController {

    private final AutoInsuranceService autoInsuranceService;

    @Autowired
    public InsurancePolicyController(AutoInsuranceService autoInsuranceService) {
        this.autoInsuranceService = autoInsuranceService;
    }

    @RequestMapping(path = "/evaluate", method = RequestMethod.POST)
    public InsurancePolicy evaluateEligibilityforInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy){
        return autoInsuranceService.evaluateEligibilityforInsurancePolicy(insurancePolicy);
    }

}
