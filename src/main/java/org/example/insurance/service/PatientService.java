package org.example.insurance.service;

import io.micrometer.observation.Observation;
import jakarta.transaction.Transactional;
import org.example.insurance.dto.PatientDto;
import org.example.insurance.entity.Patient;
import org.example.insurance.repository.PatientRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Cacheable("patients")
    public List<PatientDto> getAllPatientDetails()
    {
        patientRepository.findAll();
        System.out.println("All patients found");
        return patientRepository.findAll().stream().map(this::convertPatientEntityToDto).toList();

    }

    @Cacheable("patients")
    public Page<PatientDto> getAllPatientDetails(Pageable pageable)
    {
        Page<Patient> eachPage=patientRepository.findAll(pageable);
        System.out.println("All patients found");
        return eachPage.map(this::convertPatientEntityToPageDto);
    }

    private PatientDto convertPatientEntityToDto(Patient patient)
    {

        return  PatientDto.builder().id(patient.getId())
                .age(patient.getAge())
                .bmi(patient.getBmi())
                .charges(patient.getCharges())
                .gender(patient.getGender())
                .smoker(patient.getSmoker())
                .children(patient.getChildren()).build();



    }

    private PatientDto convertPatientEntityToPageDto(Patient patient)
    {

        return  PatientDto.builder().id(patient.getId())
                .age(patient.getAge())
                .bmi(patient.getBmi())
                .charges(patient.getCharges())
                .gender(patient.getGender())
                .smoker(patient.getSmoker())
                .children(patient.getChildren()).build();



    }
    }
