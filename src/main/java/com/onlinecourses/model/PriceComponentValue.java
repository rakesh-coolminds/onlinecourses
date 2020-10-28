package com.onlinecourses.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "price_component_vaue")
@Entity
public class PriceComponentValue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country countryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "component_id")
    private PriceComponents componentId;

    @Column(name = "value")
    private BigDecimal value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public PriceComponents getComponentId() {
        return componentId;
    }

    public void setComponentId(PriceComponents componentId) {
        this.componentId = componentId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String toString() {
      return "PriceComponentVaue{id=" + id + 
        ", countryId=" + countryId +
        ", componentId=" + componentId +
        ", value=" + value + 
        "}";
    }
}