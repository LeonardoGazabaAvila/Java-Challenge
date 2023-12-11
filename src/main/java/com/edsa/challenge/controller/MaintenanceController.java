package com.edsa.challenge.controller;

import com.edsa.challenge.dto.MaintenanceDTO;
import com.edsa.challenge.mapper.MaintenanceMapper;
import com.edsa.challenge.model.Maintenance;
import com.edsa.challenge.service.MaintenanceService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController (MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping(path = "/{maintenanceCode}")
    public ResponseEntity<MaintenanceDTO> getMaintenanceByCode (@PathVariable
                                                                    String maintenanceCode) {
        return ResponseEntity.ok(MaintenanceMapper.mapToDTO(this.maintenanceService.getMaintenanceByCode(maintenanceCode)));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Maintenance> addNewMaintenance (@RequestBody
                                                              @Valid
                                                              Maintenance maintenance) {
        return ResponseEntity.ok(this.maintenanceService.addNewMaintenance(maintenance));
    }

    @PatchMapping(path = "/{maintenanceCode}/update")
    public ResponseEntity<Maintenance> updateMaintenance (@PathVariable
                                                              String maintenanceCode,
                                                         @RequestBody
                                                         @Valid
                                                         MaintenanceDTO maintenanceDTO) {
        return ResponseEntity.ok(this.maintenanceService.updateMaintenance(maintenanceDTO, maintenanceCode));
    }

    @DeleteMapping(path = "/{maintenanceCode}/delete")
    public ResponseEntity<Maintenance> deleteMaintenanceByCode (@PathVariable String maintenanceCode) {
        this.maintenanceService.deleteMaintenanceByCode(maintenanceCode);
        return ResponseEntity.ok().build();
    }

    public List<Maintenance> getMaintenancesByDate (Date date) {
        return this.maintenanceService.getMaintenancesByDate(date);
    }
}
