package com.edsa.challenge.controller;

import com.edsa.challenge.dto.MaintenanceDTO;
import com.edsa.challenge.model.Maintenance;
import com.edsa.challenge.service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(path = "/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController (MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Maintenance> addNewMaintenance (@RequestBody @Valid Maintenance maintenance) {

        return ResponseEntity.ok(this.maintenanceService.addNewMaintenance(maintenance));
    }

    @PatchMapping(path = "/{maintenanceId}/update")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long maintenanceId,
                                                         @RequestBody @Valid MaintenanceDTO maintenanceDTO) {

    }

}
