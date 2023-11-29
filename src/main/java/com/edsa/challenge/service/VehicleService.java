package com.edsa.challenge.service;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.mapper.VehicleMapper;
import com.edsa.challenge.repository.VehicleRepository;
import com.edsa.challenge.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addNewVehicle (Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle (VehicleDTO vehicleDTO, String plateId) {
        Optional<Vehicle> optionalFound = this.vehicleRepository.findByPlateId(plateId);
        Vehicle vehicleFound = optionalFound.get();
        VehicleMapper.mapToEntityNotNullSources(vehicleDTO, vehicleFound);
        return this.vehicleRepository.save(vehicleFound);
    }
}
