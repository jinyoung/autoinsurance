package com.kosta.service;

import com.kosta.domain.Customer;
import com.kosta.domain.Policyholder;

public interface DMVService {

    String getDriverLicenseNumber(Customer customer);
    String getDriverLicenseStatus(Policyholder policyholder);

}
