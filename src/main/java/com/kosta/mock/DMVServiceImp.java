package com.kosta.mock;

import com.kosta.domain.Customer;
import com.kosta.domain.Vehicle;
import com.kosta.service.external.DMVService;

import java.util.ArrayList;
import java.util.List;

public class DMVServiceImp implements DMVService {

    @Override
    public String getDriverLicenseNumber(Customer customer) {
        return customer.getFirstName();
    }

    @Override
    public String getDriverLicenseStatus(Customer customer) {
        //this is mock
        return "G";
    }

    @Override
    public List<Vehicle> getVehicles(Customer customer) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add( new Vehicle(
                "type", "make", "model",
                "2008",customer));
        vehicles.add( new Vehicle(
                "type", "make", "model",
                "2008",customer));

        return vehicles;
    }


}
