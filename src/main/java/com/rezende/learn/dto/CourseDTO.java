package com.rezende.learn.dto;

import com.rezende.learn.entities.Course;

import java.util.UUID;

public class CourseDTO {

    private UUID id;
    private String name;
    private String synopsis;
    private String thumbnailUrl;

    public CourseDTO() { }

    private CourseDTO(UUID id, String name, String synopsis, String thumbnailUrl) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
        this.thumbnailUrl = thumbnailUrl;
    }

    public static CourseDTO from(UUID id, String name, String synopsis, String thumbnailUrl) {
        return new CourseDTO(id, name, synopsis, thumbnailUrl);
    }

    public static CourseDTO of(Course course) {
        return new CourseDTO(course.getId(), course.getName(), course.getSynopsis(), course.getThumbnailUrl());
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
