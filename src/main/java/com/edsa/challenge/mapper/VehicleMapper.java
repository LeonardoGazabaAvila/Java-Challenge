package com.edsa.challenge.mapper;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.model.Vehicle;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleMapper {
    private static final ModelMapper mapper = new ModelMapper();

    private static void configureSrcDtoSourcesNotNull() {

        mapper.typeMap(VehicleDTO.class, Vehicle.class)
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getPlateId, Vehicle::setPlateId))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getChasisId, Vehicle::setChassisId))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getEngineId, Vehicle::setEngineId))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getBrand, Vehicle::setBrand))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getColor, Vehicle::setColor))
                .addMappings(mapper -> mapper.when(Conditions.isNotNull()).map(VehicleDTO::getManufactureDate, Vehicle::setManufactureDate));
    }

    private static void configureSrcEntityFullMapping() {

        mapper.typeMap(Vehicle.class, VehicleDTO.class)
                .addMapping(Vehicle::getPlateId, VehicleDTO::setPlateId)
                .addMapping(Vehicle::getChassisId, VehicleDTO::setChasisId)
                .addMapping(Vehicle::getEngineId, VehicleDTO::setEngineId)
                .addMapping(Vehicle::getBrand, VehicleDTO::setBrand)
                .addMapping(Vehicle::getColor, VehicleDTO::setColor)
                .addMapping(Vehicle::getManufactureDate, VehicleDTO::setManufactureDate)
                .addMapping(Vehicle::getMaintenances, VehicleDTO::setMaintenances);
    }

    public static void mapToEntityNotNullSources (VehicleDTO source, Vehicle destination) {

        configureSrcDtoSourcesNotNull();
        mapper.map(source, destination);
    }

    public static VehicleDTO mapToDTO (Vehicle source) {

        configureSrcEntityFullMapping();
        return mapper.map(source, VehicleDTO.class);
    }

    public static List<VehicleDTO> mapToListDTO (List<Vehicle> vehicles) {

        configureSrcEntityFullMapping();
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDTOS.add(mapToDTO(vehicle));
        }
        return vehicleDTOS;
    }
}
