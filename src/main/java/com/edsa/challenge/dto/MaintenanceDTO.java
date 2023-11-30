package com.edsa.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {

    private String code;
    private Date date;
    private String title;
    private String observation;
    private Double cost;
}
