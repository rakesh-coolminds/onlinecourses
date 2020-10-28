package com.onlinecourses.repository;

import com.onlinecourses.model.PriceComponents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PriceComponentsRepository extends JpaRepository<PriceComponents, Integer>, JpaSpecificationExecutor<PriceComponents> {

}