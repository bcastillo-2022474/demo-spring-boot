package com.joaocastillo.demo.service;

import com.joaocastillo.demo.domain.Country;
import com.joaocastillo.demo.domain.Region;
import com.joaocastillo.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<Country> getCountriesByRegion(Region region) {
        return countryRepository.findByRegion(region);
    }

    public double getRateForCountry(String countryName) {
        return countryRepository.findByName(countryName).getRate();
    }
}
