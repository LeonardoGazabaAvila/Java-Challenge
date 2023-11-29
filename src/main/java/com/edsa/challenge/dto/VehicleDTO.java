package com.edsa.challenge.dto;

import com.edsa.challenge.model.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    @Pattern(regexp = "(([A-Z]{2}[0-9]{3}[A-Z]{2})|([A-Z]{3}[0-9]{3}))", message = "The plate id sequence is not valid.")
    private String plateId;

    private String chasisId;

    private String engineId;

    private String brand;

    private String color;

    @Null
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date manufactureDate;

    private List<Service> services;

    public void setService (Service newService) {
        this.services.add(newService);
    }

    public Service getService (Service service) {
        return this.services.stream()
                .filter(s -> s.equals(service))
                .findFirst()
                .orElse(null);
    }
}
