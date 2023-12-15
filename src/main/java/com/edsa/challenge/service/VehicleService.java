package com.edsa.challenge.service;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.mapper.VehicleMapper;
import com.edsa.challenge.repository.VehicleRepository;
import com.edsa.challenge.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByPlateId (String plateId) {
        return this.vehicleRepository.getVehicleByPlateId(plateId);
    }

    public List<Vehicle> getAllVehiclesByMaintenanceDate(Date date) {
        return this.vehicleRepository.getVehiclesWithSpecificMaintenanceDate(date);
    }

    public Vehicle addNewVehicle (Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicleByPlateId (VehicleDTO vehicleDTO, String plateId) {
        Vehicle vehicleFound = this.vehicleRepository.getVehicleByPlateId(plateId);
        VehicleMapper.mapToEntityNotNullSources(vehicleDTO, vehicleFound);
        return this.vehicleRepository.save(vehicleFound);
    }

    public void deleteVehicleByPlateId (String plateId) {
        this.vehicleRepository.deleteByPlateId(plateId);
    }
}
