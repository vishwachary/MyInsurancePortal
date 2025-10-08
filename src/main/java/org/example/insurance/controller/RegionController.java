package org.example.insurance.controller;

import org.example.insurance.dto.RegionDto;
import org.example.insurance.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RegionController {

    private RegionService regionService;
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/regions")
    public ResponseEntity<List<RegionDto>> getRegions() {
     List<RegionDto> listOfRegions= regionService.getAllRegions();
        return new ResponseEntity<>(listOfRegions, HttpStatus.OK);
    }
}
