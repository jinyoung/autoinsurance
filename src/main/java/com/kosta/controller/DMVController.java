package com.kosta.controller;

import com.kosta.domain.Customer;
import com.kosta.domain.Vehicle;
import com.kosta.service.external.DMVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/dmv")
public class DMVController {

    final DMVService dmvService;

    @Autowired
    public DMVController(DMVService dmvService) {
        this.dmvService = dmvService;
    }

    @RequestMapping(path = "/vehicle-service", method = RequestMethod.GET)
    public List<Vehicle> getVehicle(@RequestParam(name = "id") Customer customer){
        return dmvService.getVehicles(customer);
    }

}
