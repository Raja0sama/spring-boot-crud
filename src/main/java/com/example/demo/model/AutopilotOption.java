package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AUTOPILOT_OPTIONS")
public class AutopilotOption {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autopilot_options_seq")
    @SequenceGenerator(name = "autopilot_options_seq", sequenceName = "autopilot_options_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String price;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="car_id", referencedColumnName="id")
    private Car car;

}
