package com.onlinecourses.controller;

import com.onlinecourses.dto.CourseDto;
import com.onlinecourses.exception.BadRequestException;
import com.onlinecourses.exception.EntityNotFoundException;
import com.onlinecourses.service.ICourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/online-courses")
public class CourseController {

    @Autowired
    ICourseService courseService;

    private static Logger log = LoggerFactory.getLogger(CourseController.class);

    @GetMapping(value = "{country_code}/courses/{course_id}")
    public CourseDto getCourseById(@PathVariable("course_id") Integer courseId, @PathVariable("country_code") String countryCode) throws EntityNotFoundException, BadRequestException {
        log.info("@@@@Entered getCourseById");
        CourseDto courseDto=null;
        try {
            courseDto = courseService.getCourseById(courseId, countryCode);
        } catch (Exception e){
            throw new BadRequestException("Exception occurred while fetching details."+e);
        }
        log.info("@@@@Exited getCourseById");
        return courseDto;
    }
}

