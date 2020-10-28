package com.onlinecourses.service.impl;

import com.onlinecourses.dto.CourseDto;
import com.onlinecourses.dto.PriceComponentDto;
import com.onlinecourses.exception.EntityNotFoundException;
import com.onlinecourses.mapper.CourseMapper;
import com.onlinecourses.mapper.PriceComponentMapper;
import com.onlinecourses.mapper.PriceStrategyMapper;
import com.onlinecourses.model.*;
import com.onlinecourses.repository.*;
import com.onlinecourses.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseComponentValueRepository courseComponentValueRepository;

    @Autowired
    StrategiesOptionRepository strategiesOptionRepository;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public CourseDto getCourseById(Integer courseId, String countryCode) throws EntityNotFoundException {
        Course course = courseRepository.findByCourseId(courseId);
        CourseDto courseDto = CourseMapper.toCourseDto(course);
        Country country=countryRepository.findByCode(countryCode);

        if (course == null) {
            throw new EntityNotFoundException("Course Id not found : " + courseId);
        }

        if(country== null) {
            throw new EntityNotFoundException("Country code not found : " + countryCode);
        }

        List<CourseComponentValue> courseComponentValue = courseComponentValueRepository.findByCourseAndCountry(course,country);
        List<StrategiesOption> strategiesOptions = strategiesOptionRepository.findByCourse(course);
        courseDto.setPriceComponents(PriceComponentMapper.toPriceComponentDtoList(courseComponentValue));
        courseDto.setPriceStrategies(PriceStrategyMapper.toPriceStrategyDtoList(strategiesOptions));
        Float totalPrice=Float.valueOf(0);
        for(PriceComponentDto priceComponentDto:courseDto.getPriceComponents()){
            totalPrice+=priceComponentDto.getValue();
        }
        courseDto.setTotalPrice(totalPrice);
        return courseDto;
    }
}
