package com.onlinecourses.repository;

import com.onlinecourses.model.Course;
import com.onlinecourses.model.StrategiesOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StrategiesOptionRepository extends JpaRepository<StrategiesOption, Integer>, JpaSpecificationExecutor<StrategiesOption> {

    List<StrategiesOption> findByCourse(Course course);
}