package com.onlinecourses.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "course_component_value")
@Entity
public class CourseComponentValue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "component_value_id")
    private PriceComponentValue componentValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PriceComponentValue getComponentValue() {
        return componentValue;
    }

    public void setComponentValue(PriceComponentValue componentValue) {
        this.componentValue = componentValue;
    }

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course course) {
        this.course = course;
    }

    public String toString() {
      return "CourseComponentValue{id=" + id +
        ", componentValueId=" + componentValue +
        ", courseId=" + course +
        "}";
    }
}