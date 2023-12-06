package com.edsa.challenge.repository;

import com.edsa.challenge.model.Vehicle;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VehicleRepository extends ListCrudRepository<Vehicle,String> {

    public Vehicle getVehicleByPlateId(String plateId);

    public void deleteByPlateId(String plateId);


}
