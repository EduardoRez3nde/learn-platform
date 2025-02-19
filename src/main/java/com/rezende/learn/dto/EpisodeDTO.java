package com.rezende.learn.dto;

import com.rezende.learn.entities.Episode;

import java.util.UUID;

public class EpisodeDTO {

    private UUID id;
    private String name;
    private String synopsis;
    private Integer order;
    private String videoUrl;
    private Long secondsLong;

    public EpisodeDTO() { }

    private EpisodeDTO(
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

    public static EpisodeDTO from(
            UUID id,
            Long secondsLong,
            String videoUrl,
            Integer order,
            String synopsis,
            String name
    ) {
        return new EpisodeDTO(id, secondsLong, videoUrl, order, synopsis, name);
    }

    public static EpisodeDTO of(Episode episode) {
        return new EpisodeDTO(
                episode.getId(),
                episode.getSecondsLong(),
                episode.getVideoUrl(),
                episode.getOrder(),
                episode.getSynopsis(),
                episode.getName());
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
}
