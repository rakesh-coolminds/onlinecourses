package com.onlinecourses.mapper;


import com.onlinecourses.dto.CourseDto;
import com.onlinecourses.model.Course;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {
    public static CourseDto toCourseDto(Course course){
        return new ModelMapper().map(course, CourseDto.class);
    }

    public static List<CourseDto> toCourseDtoList(List<Course> source) {

        return source
                .stream()
                .map(element -> toCourseDto(element))
                .collect(Collectors.toList());
    }
}
