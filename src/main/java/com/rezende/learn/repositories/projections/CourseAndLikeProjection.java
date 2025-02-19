package com.rezende.learn.repositories.projections;

public interface CourseAndLikeProjection {

    String getId();
    String getName();
    String getSynopsis();
    String getThumbnailUrl();
    Integer getLikesCount();
}

