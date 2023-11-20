package com.edsa.challenge.dto;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name="services")
public class ServiceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plate_id", referencedColumnName = "plate_id")
    private VehicleDTO vehicle;

    @Column(name = "date")
    private Date date;

    @Column(name = "title")
    private String title;

    @Column(name = "observation")
    private String observation;

    @Column(name = "cost")
    private double cost;
}
