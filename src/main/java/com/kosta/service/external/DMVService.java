package com.kosta.service.external;

import com.kosta.domain.Customer;
import com.kosta.domain.Vehicle;

import java.util.List;

public interface DMVService {

    String getDriverLicenseNumber(Customer customer);
    String getDriverLicenseStatus(Customer customer);
    List<Vehicle> getVehicles(Customer customer);
}
