package com.edsa.challenge.controller;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.mapper.VehicleMapper;
import com.edsa.challenge.model.Vehicle;
import com.edsa.challenge.service.VehicleService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/vehicle", consumes = "application/json")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController (VehicleService vehicleService)  {
        this.vehicleService = vehicleService;
    }

    @GetMapping(path = "/{plateId}")
    public ResponseEntity<VehicleDTO> getVehicleByPlateId (@PathVariable
                                                               @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "Invalid sequence for plate id")
                                                               String plateId) {
        return ResponseEntity.ok(VehicleMapper.mapToDTO(this.vehicleService.getVehicleByPlateId(plateId)));
    }

    @GetMapping(path = "/all-maintained")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByMaintenanceDate (@RequestParam(name = "date")
                                                                                @JsonFormat(pattern = "dd/MM/yyyy")
                                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                Date maintenanceDate) {
        return ResponseEntity.ok(VehicleMapper.mapToListDTO(this.vehicleService.getAllVehiclesByMaintenanceDate(maintenanceDate)));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<VehicleDTO> addNewVehicle (@RequestBody
                                                         @Valid
                                                         Vehicle vehicle) {
        return ResponseEntity.ok(VehicleMapper.mapToDTO(this.vehicleService.addNewVehicle(vehicle)));
    }

    @PatchMapping(path = "/{plateId}/update")
    public ResponseEntity<Vehicle> updateVehicleByPlateId (@PathVariable
                                                               @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "Invalid sequence for plate id")
                                                               String plateId) {
        return ResponseEntity.ok(this.vehicleService.updateVehicleByPlateId(new VehicleDTO(), plateId));
    }

    @DeleteMapping(path = "/{plateId}/delete")
    public ResponseEntity<Vehicle> deleteVehicleByPlateId (@PathVariable
                                                               @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "Invalid sequence for plate id")
                                                               String plateId) {
        this.vehicleService.deleteVehicleByPlateId(plateId);
        return ResponseEntity.ok().build();
    }
}
