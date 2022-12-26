package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "INTERIOR_OPTIONS")

public class InteriorOption {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interior_options_seq")
    @SequenceGenerator(name = "interior_options_seq", sequenceName = "interior_options_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String price;
    @ManyToOne
    @JsonBackReference
    private Car car;
}
