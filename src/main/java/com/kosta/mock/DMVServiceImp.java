package com.kosta.mock;

import com.kosta.domain.Policyholder;
import com.kosta.domain.Vehicle;
import com.kosta.service.external.DMVService;

import java.util.ArrayList;
import java.util.List;

public class DMVServiceImp implements DMVService {

    @Override
    public String getDriverLicenseNumber(Policyholder policyholder) {
        return policyholder.getCustomer().getFirstName();
    }

    @Override
    public String getDriverLicenseStatus(Policyholder policyholder) {
        //this is mock
        return "G";
    }

    @Override
    public List<Vehicle> getVehicles(Policyholder policyholder) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add( new Vehicle(policyholder.getCustomer().getId()+"1",
                "type", "make", "model",
                "2008",policyholder.getCustomer()));
        vehicles.add( new Vehicle(policyholder.getCustomer().getId()+"2",
                "type", "make", "model",
                "2008",policyholder.getCustomer()));

        return vehicles;
    }


}
