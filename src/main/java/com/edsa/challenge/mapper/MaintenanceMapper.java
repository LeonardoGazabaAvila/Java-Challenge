package com.edsa.challenge.mapper;

import com.edsa.challenge.dto.MaintenanceDTO;
import com.edsa.challenge.model.Maintenance;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class MaintenanceMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private static void configureDtoSourcesNotNull () {

        mapper.typeMap(MaintenanceDTO.class, Maintenance.class)
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(MaintenanceDTO::getCode, Maintenance::setCode))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(MaintenanceDTO::getDate, Maintenance::setDate))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(MaintenanceDTO::getTitle, Maintenance::setTitle))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(MaintenanceDTO::getObservation, Maintenance::setObservation))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(MaintenanceDTO::getCost, Maintenance::setCost));
    }

    private static void configureEntityFullMapping () {

        mapper.typeMap(Maintenance.class, MaintenanceDTO.class)
                .addMapping(Maintenance::getCode, MaintenanceDTO::setCode)
                .addMapping(Maintenance::getDate, MaintenanceDTO::setDate)
                .addMapping(Maintenance::getTitle, MaintenanceDTO::setTitle)
                .addMapping(Maintenance::getObservation, MaintenanceDTO::setObservation)
                .addMapping(Maintenance::getCost,MaintenanceDTO::setCost);
    }

    public static void mapToEntityNotNullSources (MaintenanceDTO source, Maintenance destination) {

        configureDtoSourcesNotNull();
        mapper.map(source, destination);
    }

    public static MaintenanceDTO mapToDTO (Maintenance source) {

        configureEntityFullMapping();
        return mapper.map(source, MaintenanceDTO.class);
    }
}
