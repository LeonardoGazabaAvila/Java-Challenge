package com.edsa.challenge.model;

import com.edsa.challenge.dto.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="vehicles")
public class Vehicle {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private int id;

    @Id
    @Column(name = "plate_id")
    @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "The plate id sequence is not valid.")
    @NotNull
    private String plateId;

    @Column(name = "chasis_id")
    @NotNull
    private String chasisId;

    @Column(name = "engine_id")
    @NotNull
    private String engineId;

    @Column(name = "brand")
    @NotNull
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "manufacture_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date manufactureDate;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Service> services;

    public Vehicle (@Nonnull String plateId, @Nonnull String chasisId, @Nonnull String engineId, @Nonnull String brand, String color, @Nonnull Date manufactureDate) {
        this.plateId = plateId;
        this.chasisId = chasisId;
        this.engineId = engineId;
        this.brand = brand;
        this.color = color;
        this.manufactureDate = manufactureDate;
    }

    public void setService (Service newService) {
        this.services.add(newService);
    }

    public Service getService (Service service) {
        return this.services.stream()
                .filter(s -> s.equals(service))
                .findFirst()
                .orElse(null);
    }

    public void updateThisVehicle (VehicleDTO vehicleDTO) {

    }
}
