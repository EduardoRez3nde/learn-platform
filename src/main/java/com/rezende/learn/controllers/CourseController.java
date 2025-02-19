package com.rezende.learn.controllers;


import com.rezende.learn.dto.CourseAndEpisodeDTO;
import com.rezende.learn.dto.CourseAndLikeDTO;
import com.rezende.learn.dto.CourseDTO;
import com.rezende.learn.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(courseService.findAll(pageable));
    }

    @GetMapping(value = "/{courseId}")
    public ResponseEntity<CourseAndEpisodeDTO> findById(@PathVariable("courseId") UUID id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping(value = "/featured")
    public ResponseEntity<Set<CourseDTO>> randomFeaturedCourses() {
        return ResponseEntity.ok(courseService.randomFeaturedCourses());
    }

    @GetMapping(value = "/latest")
    public ResponseEntity<List<CourseDTO>> topTenLatestCourses() {
        return ResponseEntity.ok(courseService.topTenLatestCourses());
    }

    @GetMapping(value = "/most-liked")
    public ResponseEntity<List<CourseAndLikeDTO>> topTenMostLikedCourses() {
        return ResponseEntity.ok(courseService.topTenMostLikedCourses());
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<CourseDTO>> findByCourseName(@RequestParam("name") String name, Pageable pageable) {
        return ResponseEntity.ok(courseService.findByCourseName(name, pageable));
    }
}
