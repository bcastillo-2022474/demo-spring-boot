package com.joaocastillo.demo.repository;

import com.joaocastillo.demo.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
