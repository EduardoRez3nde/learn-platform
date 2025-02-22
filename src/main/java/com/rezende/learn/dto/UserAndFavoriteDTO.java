package com.rezende.learn.dto;

import com.rezende.learn.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserAndFavoriteDTO {

    private UUID id;
    private String fullName;

    private final List<CourseDTO> courses = new ArrayList<>();

    public UserAndFavoriteDTO() { }

    private UserAndFavoriteDTO(UUID id, String firstname, String lastname, List<CourseDTO> courses) {
        this.id = id;
        this.fullName = fullName(firstname, lastname);
        this.courses.addAll(courses);
    }

    public static UserAndFavoriteDTO from(UUID id, String firstName, String lastname, List<CourseDTO> courses) {
        return new UserAndFavoriteDTO(id, firstName, lastname, courses);
    }

    public static UserAndFavoriteDTO of(User entity) {
        return new UserAndFavoriteDTO(
                entity.getId(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getFavorites().stream().map(favorite -> CourseDTO.of(favorite.getCourse())).toList()
        );
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

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public String fullName(String firstname, String lastname) {
        return firstname + " " + lastname;
    }
}
