package com.onlinecourses.repository;

import com.onlinecourses.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

    Country findByCode(String countryCode);
}