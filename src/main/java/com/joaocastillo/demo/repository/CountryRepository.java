package com.joaocastillo.demo.repository;

import com.joaocastillo.demo.domain.Country;
import com.joaocastillo.demo.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByRegion(Region region);

    Country findByName(String name);
}
