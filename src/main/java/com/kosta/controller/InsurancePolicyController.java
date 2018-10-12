package com.kosta.controller;

import com.kosta.domain.InsurancePolicy;
import com.kosta.repository.InsurancePolicyRepository;
import com.kosta.service.AutoInsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@Slf4j
@RestController
//@RequestMapping("/insurence-policy")
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

}
