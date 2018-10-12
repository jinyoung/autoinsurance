package com.kosta.controller;

import com.kosta.domain.InsurancePolicy;
import com.kosta.service.AutoInsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/insurence-policy")
public class InsurancePolicyController {

    private final AutoInsuranceService autoInsuranceService;

    @Autowired
    public InsurancePolicyController(AutoInsuranceService autoInsuranceService) {
        this.autoInsuranceService = autoInsuranceService;
    }

    @RequestMapping(path = "{insurance-policy-id}/evaluate", method = RequestMethod.POST)
    public InsurancePolicy evaluateEligibilityforInsurancePolicy(@PathVariable("insurance-policy-id") long insurancePolicy){
        log.info("iiiii"+insurancePolicy);

        return autoInsuranceService.evaluateEligibilityforInsurancePolicy(insurancePolicy);
        //return null;
    }

}
