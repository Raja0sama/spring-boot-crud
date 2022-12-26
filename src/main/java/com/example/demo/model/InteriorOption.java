package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "INTERIOR_OPTIONS")

public class InteriorOption extends Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interior_options_seq")
    @SequenceGenerator(name = "interior_options_seq", sequenceName = "interior_options_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String price;
    @ManyToOne
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;
}
