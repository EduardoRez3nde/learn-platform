package com.rezende.learn.dto;

import com.rezende.learn.entities.Like;
import com.rezende.learn.entities.User;

import java.util.UUID;

public class LikeCourseDTO {

    private UUID id;
    private String fullName;
    private CourseDTO course;

    public LikeCourseDTO() { }

    private LikeCourseDTO(UUID id, String fullName, CourseDTO course) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
    }

    public static LikeCourseDTO from(UUID id, String fullName, CourseDTO course) {
        return new LikeCourseDTO(id, fullName, course);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
