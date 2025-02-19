package com.rezende.learn.services;

import com.rezende.learn.dto.CourseAndEpisodeDTO;
import com.rezende.learn.dto.CourseAndLikeDTO;
import com.rezende.learn.dto.CourseDTO;
import com.rezende.learn.entities.Course;
import com.rezende.learn.repositories.projections.CourseAndLikeProjection;
import com.rezende.learn.repositories.CourseRepository;
import com.rezende.learn.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        return courses.map(CourseDTO::of);
    }

    @Transactional(readOnly = true)
    public CourseAndEpisodeDTO findById(UUID id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id %s not found", id));
        return CourseAndEpisodeDTO.from(course);
    }

    @Transactional(readOnly = true)
    public Set<CourseDTO> randomFeaturedCourses() {
        Set<Course> courses = courseRepository.randomFeaturedCourses();
        return courses.stream().map(CourseDTO::of).collect(Collectors.toSet());
    }

    @Transactional(readOnly = true)
    public List<CourseDTO> topTenLatestCourses() {
        List<Course> courses = courseRepository.topTenLatestCourses();
        return courses.stream().map(CourseDTO::of).toList();
    }

    @Transactional(readOnly = true)
    public List<CourseAndLikeDTO> topTenMostLikedCourses() {
        List<CourseAndLikeProjection> courses = courseRepository.topTenMostLikedCourses();
        return courses.stream().map(CourseAndLikeDTO::from).toList();
    }

    @Transactional(readOnly = true)
    public Page<CourseDTO> findByCourseName(String name, Pageable pageable) {
        Page<Course> courses = courseRepository.findByCourseName(name, pageable);
        return courses.map(CourseDTO::of);
    }
}
