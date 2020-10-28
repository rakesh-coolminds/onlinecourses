package com.onlinecourses.repository;

import com.onlinecourses.model.Country;
import com.onlinecourses.model.Course;
import com.onlinecourses.model.CourseComponentValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseComponentValueRepository extends JpaRepository<CourseComponentValue, Integer>, JpaSpecificationExecutor<CourseComponentValue> {

    List<CourseComponentValue> findByCourse(Course course);


    @Query("FROM CourseComponentValue ccv where ccv.course=:course and ccv.componentValue.countryId=:country")
    List<CourseComponentValue> findByCourseAndCountry(Course course, Country country);
}