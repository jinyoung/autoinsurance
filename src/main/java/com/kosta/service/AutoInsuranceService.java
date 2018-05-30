package com.kosta.service;

import com.kosta.domain.Customer;
import com.kosta.domain.Policyholder;

public interface AutoInsuranceService {
    Policyholder promotePolicyholder(Customer customer);
}
