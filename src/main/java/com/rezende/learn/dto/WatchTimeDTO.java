package com.rezende.learn.dto;

import com.rezende.learn.entities.WatchTime;

public class WatchTimeDTO {

    private UserDTO user;
    private EpisodeDTO episode;
    private Long secondsLong;

    public WatchTimeDTO() {}

    private WatchTimeDTO(UserDTO user, EpisodeDTO episode) {
        this.user = user;
        this.episode = episode;
    }

    public static WatchTimeDTO from(UserDTO user, EpisodeDTO episode) {
        return new WatchTimeDTO(user, episode);
    }

    public static WatchTimeDTO of(WatchTime entity) {
        return new WatchTimeDTO(UserDTO.of(entity.getUser()), EpisodeDTO.of(entity.getEpisode()));
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public EpisodeDTO getEpisode() {
        return episode;
    }

    public void setEpisode(EpisodeDTO episode) {
        this.episode = episode;
    }

    public Long getSecondsLong() {
        return secondsLong;
    }

    public void setSecondsLong(Long secondsLong) {
        this.secondsLong = secondsLong;
    }
}