package com.edsa.challenge.repository;

import com.edsa.challenge.model.Maintenance;
import org.springframework.data.repository.ListCrudRepository;

public interface MaintenanceRepository extends ListCrudRepository<Maintenance, Long> {

    public Maintenance getMaintenanceByCode(String code);
}
