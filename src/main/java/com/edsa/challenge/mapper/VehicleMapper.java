package com.edsa.challenge.mapper;

import com.edsa.challenge.dto.VehicleDTO;
import com.edsa.challenge.model.Vehicle;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    private final ModelMapper mapperForDTO;

    public VehicleMapper () {
        this.mapperForDTO = new ModelMapper();
        this.configureMapperForDTO();
    }

    public void configureMapperForDTO () {

        Condition sourceNotNull = asd -> asd.getSource() != null;
        this.mapperForDTO.typeMap(VehicleDTO.class, Vehicle.class)
                .addMapping(VehicleDTO::getPlateId, Vehicle::setPlateId)
                .addMapping(VehicleDTO::getChasisId, Vehicle::setChasisId)
                .addMapping(VehicleDTO::getEngineId, Vehicle::setEngineId)
                .addMapping(VehicleDTO::getBrand, Vehicle::setBrand)
                .addMapping(VehicleDTO::getColor, Vehicle::setColor)
                .addMapping(VehicleDTO::getManufactureDate, Vehicle::setManufactureDate);
    }

    public ModelMapper getMapperForDTO () {
        return this.mapperForDTO;
    }
}
