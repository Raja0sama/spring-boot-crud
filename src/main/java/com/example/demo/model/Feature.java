package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "Features")
public class Feature extends Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "features_seq")
    @SequenceGenerator(name = "features_seq", sequenceName = "features_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String price;

    @ManyToOne
    @Nullable
    @JsonBackReference
    private Car car;

}