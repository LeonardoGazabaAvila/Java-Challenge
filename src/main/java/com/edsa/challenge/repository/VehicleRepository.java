package com.edsa.challenge.repository;

import com.edsa.challenge.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VehicleRepository extends ListCrudRepository<Vehicle,String> {

    Vehicle getVehicleByPlateId(String plateId);

    void deleteByPlateId(String plateId);

    @Query("select v from Vehicle v join fetch v.maintenances m where m.date = :date")
    List<Vehicle> getVehiclesWithSpecificMaintenanceDate (@Param("date")Date date);
}
