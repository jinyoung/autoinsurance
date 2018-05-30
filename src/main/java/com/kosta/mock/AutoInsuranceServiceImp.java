package com.kosta.mock;

import com.kosta.domain.Customer;
import com.kosta.domain.Policyholder;
import com.kosta.repository.PolicyholderRepository;
import com.kosta.service.AutoInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoInsuranceServiceImp implements AutoInsuranceService {

    private final PolicyholderRepository policyholderRepository;

    @Autowired
    public AutoInsuranceServiceImp(PolicyholderRepository policyholderRepository) {
        this.policyholderRepository = policyholderRepository;
    }

    @Override
    public Policyholder promotePolicyholder(Customer customer) {
        return null;
    }

}
