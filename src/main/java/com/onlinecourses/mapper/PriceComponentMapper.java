package com.onlinecourses.mapper;

import com.onlinecourses.dto.PriceComponentDto;
import com.onlinecourses.model.CourseComponentValue;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

public class PriceComponentMapper {
    public static PriceComponentDto toPriceComponentDto(CourseComponentValue priceComponents){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.typeMap(CourseComponentValue.class, PriceComponentDto.class)
                .addMappings(mapper -> mapper.map(src -> src.getComponentValue().getComponentId().getName(), PriceComponentDto::setName))
        .addMappings(mapper -> mapper.map(src -> src.getComponentValue().getComponentId().getId(), PriceComponentDto::setId));
        return modelMapper.map(priceComponents, PriceComponentDto.class);
    }

    public static List<PriceComponentDto> toPriceComponentDtoList(List<CourseComponentValue> source) {

        return source
                .stream()
                .map(element -> toPriceComponentDto(element))
                .collect(Collectors.toList());
    }
}
