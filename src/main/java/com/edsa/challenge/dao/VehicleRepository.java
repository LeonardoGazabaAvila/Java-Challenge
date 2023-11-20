package com.edsa.challenge.dao;

import com.edsa.challenge.dto.VehicleDTO;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VehicleRepository extends ListCrudRepository<VehicleDTO,Long> {

    public Optional<VehicleDTO> getVehicleDTOByPlateId(String plateId);
}
