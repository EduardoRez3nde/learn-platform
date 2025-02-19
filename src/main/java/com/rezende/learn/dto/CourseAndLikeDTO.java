package com.rezende.learn.dto;

import com.rezende.learn.repositories.projections.CourseAndLikeProjection;

import java.util.UUID;

public class CourseAndLikeDTO extends CourseDTO {

    private Integer liked;

    public CourseAndLikeDTO() {
        super();
    }

    private CourseAndLikeDTO(UUID id, String name, String synopsis, String thumbnailUrl, Integer liked) {
        super(id, name, synopsis, thumbnailUrl);
        this.liked = liked;
    }

    public static CourseAndLikeDTO from(CourseAndLikeProjection entity) {
        return new CourseAndLikeDTO(
                UUID.fromString(entity.getId()),
                entity.getName(),
                entity.getSynopsis(),
                entity.getThumbnailUrl(),
                entity.getLikesCount()
        );
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }
}
