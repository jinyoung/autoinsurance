package com.kosta.controller;

import com.kosta.domain.InsurancePolicy;
import com.kosta.repository.InsurancePolicyRepository;
import com.kosta.service.AutoInsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@Slf4j
@RestController
public class InsurancePolicyController {

    @Resource
    private InsurancePolicyRepository insurancePolicyRepository;
    private final AutoInsuranceService autoInsuranceService;

    @Autowired
    public InsurancePolicyController(AutoInsuranceService autoInsuranceService) {
        this.autoInsuranceService = autoInsuranceService;
    }

    @RequestMapping(path = "insurance-policy/{insurance-policy-id}/evaluate", method = RequestMethod.POST)
    public InsurancePolicy evaluateEligibilityforInsurancePolicy(@PathVariable("insurance-policy-id") long id){
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Not Found Entity"));
        autoInsuranceService.evaluateEligibilityforInsurancePolicy(insurancePolicy);
        return insurancePolicy;
        //return null;
    }

    @RequestMapping(path = "insurance-policy/{insurance-policy-id}/calculate", method = RequestMethod.POST)
    public InsurancePolicy calculateInsurancePolicy(@PathVariable("insurance-policy-id") long id){
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Not Found Entity"));
        insurancePolicy.calculateInsurancePremium();
        return insurancePolicyRepository.save(insurancePolicy);
        //return null;
    }
}
