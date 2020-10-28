package com.onlinecourses.repository;

import com.onlinecourses.model.PriceStrategies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PriceStrategiesRepository extends JpaRepository<PriceStrategies, Integer>, JpaSpecificationExecutor<PriceStrategies> {

}