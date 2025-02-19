package com.rezende.learn.dto;

import com.rezende.learn.entities.Course;

import java.util.*;

public class CourseAndEpisodeDTO  {

    private CourseDTO course;
    private final List<EpisodeDTO> episodes = new ArrayList<>();

    public CourseAndEpisodeDTO() { }

    private CourseAndEpisodeDTO(Course entity) {
        course = CourseDTO.of(entity);
        entity.getEpisodes().forEach(episode -> episodes.add(EpisodeDTO.of(episode)));
        Collections.sort(episodes, Comparator.comparing(EpisodeDTO::getOrder));
    }

    public static CourseAndEpisodeDTO from(Course entity) {
        return new CourseAndEpisodeDTO(entity);
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public List<EpisodeDTO> getEpisodes() {
        return episodes;
    }

}
