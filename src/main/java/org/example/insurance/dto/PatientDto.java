package org.example.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {

    private Long id;
    private int age;
    private String gender;
    private double bmi;
    private int children;
    private String smoker;
    private double charges;
}
