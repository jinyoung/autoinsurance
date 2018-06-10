package com.kosta.controller;

import com.kosta.domain.Policyholder;
import com.kosta.domain.Vehicle;
import com.kosta.service.external.DMVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Vehicle> getVehicle(@RequestParam(name = "id") Policyholder policyholder){
        return dmvService.getVehicles(policyholder);
    }

}
