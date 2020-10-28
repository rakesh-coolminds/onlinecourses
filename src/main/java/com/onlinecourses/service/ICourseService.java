package com.onlinecourses.service;

import com.onlinecourses.dto.CourseDto;
import com.onlinecourses.exception.BadRequestException;
import com.onlinecourses.exception.EntityNotFoundException;

public interface ICourseService {

    CourseDto getCourseById(Integer courseId, String countryCode) throws EntityNotFoundException;
}
