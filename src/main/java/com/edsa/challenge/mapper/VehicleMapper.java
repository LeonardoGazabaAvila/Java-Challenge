package com.edsa.challenge.mapper;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.model.Vehicle;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    private static final ModelMapper mapper = new ModelMapper();

    private static void configureDtoSourcesNotNull () {

        mapper.typeMap(VehicleDTO.class, Vehicle.class)
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getPlateId, Vehicle::setPlateId))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getChasisId, Vehicle::setChasisId))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getEngineId, Vehicle::setEngineId))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getBrand, Vehicle::setBrand))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getColor, Vehicle::setColor))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getManufactureDate, Vehicle::setManufactureDate));
    }

    private static void configureEntityFullMapping() {

        mapper.typeMap(Vehicle.class, VehicleDTO.class)
                .addMapping(Vehicle::getPlateId, VehicleDTO::setPlateId)
                .addMapping(Vehicle::getChasisId, VehicleDTO::setChasisId)
                .addMapping(Vehicle::getEngineId, VehicleDTO::setEngineId)
                .addMapping(Vehicle::getBrand, VehicleDTO::setBrand)
                .addMapping(Vehicle::getColor, VehicleDTO::setColor)
                .addMapping(Vehicle::getManufactureDate, VehicleDTO::setManufactureDate)
                .addMapping(Vehicle::getMaintenances, VehicleDTO::setMaintenances);
    }

    public static void mapToEntityNotNullSources (VehicleDTO source, Vehicle destination) {

        configureDtoSourcesNotNull();
        mapper.map(source, destination);
    }

    public static Vehicle mapToEntityNotNullSources (VehicleDTO source) {
        configureDtoSourcesNotNull();
        return mapper.map(source, Vehicle.class);
    }

    public static void mapToDTO (Vehicle source, VehicleDTO destination) {

        configureEntityFullMapping();
        mapper.map(source, destination);
    }

    public static VehicleDTO mapToDTO (Vehicle source) {

        configureEntityFullMapping();
        return mapper.map(source, VehicleDTO.class);
    }
}
