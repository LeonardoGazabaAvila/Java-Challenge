package com.edsa.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="services")
public class Maintenance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plate_id", referencedColumnName = "plate_id")
    @NotNull
    @ToString.Exclude
    private Vehicle vehicle;

    @Column(name = "code")
    @NotNull
    @Id
    private String code;

    @Column(name = "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date date;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "observation")
    private String observation;

    @Column(name = "cost")
    @NotNull
    private double cost;
}
