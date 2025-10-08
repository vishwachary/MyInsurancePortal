package org.example.insurance.controller;

import org.example.insurance.dto.PatientDto;
import org.example.insurance.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    private PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        long startTime = System.currentTimeMillis();
        List<PatientDto> allPatientDetails = patientService.getAllPatientDetails();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + " milliseconds");
        return ResponseEntity.ok(allPatientDetails);


    }

    @GetMapping("/patientswithpaging")
    public ResponseEntity<Page<PatientDto>> getAllPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        long startTime = System.currentTimeMillis();

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable requestPage = PageRequest.of(page, size , sort);

        //List<PatientDto> allPatientDetails = patientService.getAllPatientDetails(requestPage);
        Page<PatientDto> patientPage =patientService.getAllPatientDetails(requestPage);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken with Pageable: " + (endTime - startTime) + " milliseconds");
        return ResponseEntity.ok(patientPage);


    }
}