package com.edsa.challenge.controller;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.mapper.VehicleMapper;
import com.edsa.challenge.model.Vehicle;
import com.edsa.challenge.service.VehicleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<VehicleDTO> addNewVehicle (@RequestBody @Valid Vehicle vehicle) {

        Vehicle savedVehicle = this.vehicleService.addNewVehicle(vehicle);
        return ResponseEntity.ok(VehicleMapper.mapToDTO(savedVehicle));
    }

    @PatchMapping(path = "/{plateId}/update")
    public ResponseEntity<Vehicle> updateVehicle (@RequestBody @Valid VehicleDTO vehicleDTO,
                                                  @PathVariable @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "Invalid sequence for plate id") String plateId) {

        VehicleDTO updatedDTO = new VehicleDTO();
        return ResponseEntity.ok(this.vehicleService.updateVehicle(vehicleDTO, plateId));
    }

    @DeleteMapping(path = "/{plateId}/delete")
    public ResponseEntity deleteVehicle (@PathVariable @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "Invalid sequence for plate id") String plateId) {

        this.vehicleService.deleteVehicle(plateId);
        return ResponseEntity.ok().build();
    }
}
