package com.joaocastillo.demo.controller;

import com.joaocastillo.demo.domain.Country;
import com.joaocastillo.demo.domain.Region;
import com.joaocastillo.demo.service.CountryService;
import com.joaocastillo.demo.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;
    private final RegionService regionService;

    CountryController(CountryService countryService, RegionService regionService) {
        this.countryService = countryService;
        this.regionService = regionService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("region/{regionId}")
    public List<Country> getCountriesByRegion(@PathVariable Long regionId) {
        Region region = regionService.getRegionById(regionId);
        return countryService.getCountriesByRegion(region);
    }
}

