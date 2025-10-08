package org.example.insurance.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.insurance.entity.Patient;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    private Long id;
    private String name;
    private List<Patient> patients;
}
