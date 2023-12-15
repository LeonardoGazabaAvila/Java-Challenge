package com.edsa.challenge.service;

import com.edsa.challenge.dto.MaintenanceDTO;
import com.edsa.challenge.mapper.MaintenanceMapper;
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

    public Maintenance getMaintenanceByCode (String code) {
        return this.maintenanceRepository.getMaintenanceByCode(code);
    }

    public Maintenance addNewMaintenance (Maintenance maintenance) {
        return this.maintenanceRepository.save(maintenance);
    }

    public Maintenance updateMaintenance (MaintenanceDTO maintenanceDTO, String maintenanceCode) {
        Maintenance maintenanceFound = this.maintenanceRepository.getMaintenanceByCode(maintenanceCode);
        MaintenanceMapper.mapToEntityNotNullSources(maintenanceDTO, maintenanceFound);
        return this.maintenanceRepository.save(maintenanceFound);
    }

    public void deleteMaintenanceByCode (String maintenanceCode) {
        this.maintenanceRepository.deleteMaintenanceByCode(maintenanceCode);
    }
}
