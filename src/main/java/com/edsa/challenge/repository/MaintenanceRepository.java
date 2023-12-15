package com.edsa.challenge.repository;

import com.edsa.challenge.model.Maintenance;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Date;
import java.util.List;

public interface MaintenanceRepository extends ListCrudRepository<Maintenance, Long> {

    Maintenance getMaintenanceByCode(String code);

    void deleteMaintenanceByCode (String maintenanceCode);

}
