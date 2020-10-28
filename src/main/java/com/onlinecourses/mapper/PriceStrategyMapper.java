package com.onlinecourses.mapper;


import com.onlinecourses.dto.PriceStrategyDto;
import com.onlinecourses.model.StrategiesOption;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PriceStrategyMapper {
    public static PriceStrategyDto toPriceStrategyDto(StrategiesOption priceStrategies){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.typeMap(StrategiesOption.class, PriceStrategyDto.class)
                .addMappings(mapper -> mapper.map(src -> src.getPriceStrategy().getName(), PriceStrategyDto::setName))
                .addMappings(mapper -> mapper.map(src -> src.getPriceStrategy().getId(), PriceStrategyDto::setId));

        return modelMapper.map(priceStrategies, PriceStrategyDto.class);
    }

    public static List<PriceStrategyDto> toPriceStrategyDtoList(List<StrategiesOption> source) {

        return source
                .stream()
                .map(element -> toPriceStrategyDto(element))
                .collect(Collectors.toList());
    }
}
