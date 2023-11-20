package com.edsa.challenge.controller;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.service.VehicleService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController (VehicleService vehicleService)  {
        this.vehicleService = vehicleService;
    }

    @GetMapping(path = "/{plateId}")
    public ResponseEntity<VehicleDTO> getVehicleByPlate (@PathVariable @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))") String plateId) {
        return this.vehicleService.
    }

    @PostMapping(path = "/add")
    public ResponseEntity<VehicleDTO> addNewVehicle (@RequestBody @Valid VehicleDTO vehicle) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.vehicleService.addNewVehicle(vehicle));
    }

    @PatchMapping(path = "/update/{vehicleId}")
    public ResponseEntity<VehicleDTO> updateVehicle (@RequestBody VehicleDTO vehicle) {


    }
}
