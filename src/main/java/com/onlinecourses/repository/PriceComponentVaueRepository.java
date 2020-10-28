package com.onlinecourses.repository;

import com.onlinecourses.model.PriceComponentValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PriceComponentVaueRepository extends JpaRepository<PriceComponentValue, Integer>, JpaSpecificationExecutor<PriceComponentValue> {

}