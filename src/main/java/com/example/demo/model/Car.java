package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "CARS")
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_seq")
    @SequenceGenerator(name = "cars_seq", sequenceName = "cars_seq", allocationSize = 1)
    private Long id;
    private String model;
    private String basePrice;
    @OneToMany(mappedBy="car",fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Feature> features;
    @OneToMany(mappedBy="car",fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<ExteriorColor> exteriorColors;
    @OneToMany(mappedBy="car",fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<InteriorOption> interiorOptions;
    @OneToMany(mappedBy="car",fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<AutopilotOption> autopilotOptions;
    private String imageLink;
}

