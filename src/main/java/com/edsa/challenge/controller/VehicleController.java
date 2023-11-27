package com.edsa.challenge.controller;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.model.Vehicle;
import com.edsa.challenge.service.VehicleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "/vehicle", consumes = "application/json")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController (VehicleService vehicleService)  {
        this.vehicleService = vehicleService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Vehicle> addNewVehicle (@RequestBody @Valid Vehicle vehicle) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.vehicleService.addNewVehicle(vehicle));
    }

    @PatchMapping(path = "/{plateId}/update")
    public ResponseEntity<Vehicle> updateVehicle (@RequestBody @Valid VehicleDTO vehicleDTO,
                                                  @PathVariable @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "Invalid sequence for plate id") String plateId) {
            return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.updateVehicle(vehicleDTO, plateId));
    }
}
