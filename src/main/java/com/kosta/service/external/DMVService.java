package com.kosta.service.external;

import com.kosta.domain.Policyholder;
import com.kosta.domain.Vehicle;

import java.util.List;

public interface DMVService {

    String getDriverLicenseNumber(Policyholder policyholder);
    String getDriverLicenseStatus(Policyholder policyholder);
    List<Vehicle> getVehicles(Policyholder policyholder);
}
