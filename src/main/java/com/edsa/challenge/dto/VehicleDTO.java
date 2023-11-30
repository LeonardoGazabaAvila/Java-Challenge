package com.edsa.challenge.dto;

import com.edsa.challenge.model.Maintenance;
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date manufactureDate;

    private List<Maintenance> maintenances;

    public void setMaintenance (Maintenance newMaintenance) {
        this.maintenances.add(newMaintenance);
    }

    public Maintenance getMaintenance (Maintenance maintenance) {
        return this.maintenances.stream()
                .filter(s -> s.equals(maintenance))
                .findFirst()
                .orElse(null);
    }
}
