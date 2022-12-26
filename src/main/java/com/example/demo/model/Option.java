package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
public class Option {
    @ManyToOne
    @JsonBackReference
    private Car car;

    private Long id;
}
