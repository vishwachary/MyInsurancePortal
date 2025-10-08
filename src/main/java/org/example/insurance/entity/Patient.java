package org.example.insurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String gender;
    private double bmi;
    private int children;
    private String smoker;
    private double charges;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
