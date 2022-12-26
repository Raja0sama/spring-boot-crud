package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "EXTERIOR_COLORS")
public class ExteriorColor extends Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exterior_colors_seq")
    @SequenceGenerator(name = "exterior_colors_seq", sequenceName = "exterior_colors_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String price;
    @ManyToOne
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;
}