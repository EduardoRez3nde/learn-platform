package com.rezende.learn.repositories;

import com.rezende.learn.entities.Course;
import com.rezende.learn.repositories.projections.CourseAndLikeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query(nativeQuery = true, value =
        "SELECT * FROM tb_course " +
        "WHERE featured = true " +
        "ORDER BY RANDOM() LIMIT 3")
    Set<Course> randomFeaturedCourses();

    @Query(nativeQuery = true, value =
        "SELECT * FROM tb_course " +
        "ORDER BY created_at DESC LIMIT 10")
    List<Course> topTenLatestCourses();

    @Query(nativeQuery = true, value =
        "SELECT CAST(tb_course.id AS VARCHAR) AS id, tb_course.name, tb_course.synopsis, tb_course.thumbnail_url, " +
        "COUNT(tb_like.user_id) AS likes_count " +
        "FROM tb_course " +
        "INNER JOIN tb_like ON tb_course.id = tb_like.course_id " +
        "INNER JOIN tb_user ON tb_like.user_id = tb_user.id " +
        "GROUP BY tb_course.id " +
        "ORDER BY likes_count DESC LIMIT 10")
    List<CourseAndLikeProjection> topTenMostLikedCourses();

    @Query(nativeQuery = true, value =
        "SELECT * FROM tb_course " +
        "WHERE LOWER(name) LIKE LOWER(CONCAT(:name, '%'))")
    Page<Course> findByCourseName(@Param("name") String name, Pageable pageable);
}
