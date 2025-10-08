package org.example.insurance.service;

import org.example.insurance.dto.RegionDto;
import org.example.insurance.entity.Region;
import org.example.insurance.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<RegionDto> getAllRegions() {
       return  regionRepository.findAll()
               .stream().map(this::convertToDto)
               .toList();


    }


    private RegionDto convertToDto(Region region) {

        return RegionDto.builder().id(region.getId())
                .name(region.getName()).build();

    }

}
