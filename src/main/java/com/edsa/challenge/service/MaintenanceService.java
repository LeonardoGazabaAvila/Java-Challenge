package com.edsa.challenge.service;

import com.edsa.challenge.model.Maintenance;
import com.edsa.challenge.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceService (MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Maintenance addNewMaintenance (Maintenance maintenance) {
        return this.maintenanceRepository.save(maintenance);
    }
}
