package com.edsa.challenge.service;

import com.edsa.challenge.dao.VehicleRepository;
import com.edsa.challenge.dto.VehicleDTO;
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

    public VehicleDTO getVehicleByPlate (String plateId) {
        Optional<VehicleDTO> vehicleFound = this.vehicleRepository.getVehicleDTOByPlateId(plateId);
    }

    public VehicleDTO addNewVehicle (VehicleDTO vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    public VehicleDTO updateVehicle (){
        this.vehicleRepository.
    }
}
