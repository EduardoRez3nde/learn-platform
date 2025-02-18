package com.rezende.learn.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_episode")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String synopsis;

    @Column(name = "episode_order")
    private Integer order;
    private String videoUrl;
    private Long secondsLong;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "id.episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<WatchTime> watchTimes = new HashSet<>();

    public Episode() { }

    private Episode(
            UUID id,
            Long secondsLong,
            String videoUrl,
            Integer order,
            String synopsis,
            String name
    ) {
        this.id = id;
        this.secondsLong = secondsLong;
        this.videoUrl = videoUrl;
        this.order = order;
        this.synopsis = synopsis;
        this.name = name;
    }

    public static Episode from(
            UUID id,
            Long secondsLong,
            String videoUrl,
            Integer order,
            String synopsis,
            String name,
            Episode episode
    ) {
        return new Episode(id, secondsLong, videoUrl, order, synopsis, name);
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getSecondsLong() {
        return secondsLong;
    }

    public void setSecondsLong(Long secondsLong) {
        this.secondsLong = secondsLong;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<WatchTime> getWatchTimes() {
        return watchTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return Objects.equals(getId(), episode.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
