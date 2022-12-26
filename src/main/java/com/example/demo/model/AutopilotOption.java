package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "AUTOPILOT_OPTIONS")
public class AutopilotOption extends Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autopilot_options_seq")
    @SequenceGenerator(name = "autopilot_options_seq", sequenceName = "autopilot_options_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String price;
    @ManyToOne
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;

}
