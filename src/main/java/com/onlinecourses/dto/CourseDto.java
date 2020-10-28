
package com.onlinecourses.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "course_id",
    "name",
    "description",
    "base_price",
    "duration_in_months",
    "price_strategies",
    "price_components"
})
@Data
public class CourseDto {

    @JsonProperty("course_id")
    private Integer courseId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("total_price")
    private Float totalPrice;
    @JsonProperty("duration_in_months")
    private Integer durationInMonths;
    @JsonProperty("price_strategies")
    private List<PriceStrategyDto> priceStrategies = null;
    @JsonProperty("price_components")
    private List<PriceComponentDto> priceComponents = null;
}
