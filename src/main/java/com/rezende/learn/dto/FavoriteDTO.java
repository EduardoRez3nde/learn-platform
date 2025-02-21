package com.rezende.learn.dto;

import java.util.UUID;

public class FavoriteDTO {

    private UUID userId;
    private UUID courseId;

    public FavoriteDTO() { }

    private FavoriteDTO(UUID userId, UUID courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public static FavoriteDTO from(UUID userId, UUID courseId) {
        return new FavoriteDTO(userId, courseId);
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}
