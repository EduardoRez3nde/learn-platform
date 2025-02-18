package com.rezende.learn.dto;

import com.rezende.learn.entities.Category;
import com.rezende.learn.entities.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryAndCourseDTO {

    private UUID id;
    private String name;
    private final List<CourseDTO> courses = new ArrayList<>();

    public CategoryAndCourseDTO() { }

    private CategoryAndCourseDTO(UUID id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        courses.forEach(course -> addCourse(CourseDTO.of(course)));
    }

    public static CategoryAndCourseDTO from(Category entity) {
        return new CategoryAndCourseDTO(entity.getId(), entity.getName(), entity.getCourses());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void addCourse(CourseDTO course) {
        courses.add(course);
    }
}
