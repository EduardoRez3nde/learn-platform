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
    private String order;
    private String videoUrl;
    private Long secondsLong;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "id.episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<WatchTime> watchTimes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;

    public Episode() { }

    private Episode(
            UUID id,
            Long secondsLong,
            String videoUrl,
            String order,
            String synopsis,
            String name,
            Episode episode
    ) {
        this.id = id;
        this.secondsLong = secondsLong;
        this.videoUrl = videoUrl;
        this.order = order;
        this.synopsis = synopsis;
        this.name = name;
        this.episode = episode;
    }

    public static Episode from(
            UUID id,
            Long secondsLong,
            String videoUrl,
            String order,
            String synopsis,
            String name,
            Episode episode
    ) {
        return new Episode(id, secondsLong, videoUrl, order, synopsis, name, episode);
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
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

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
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
