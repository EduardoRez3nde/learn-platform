package com.rezende.learn.entities.pk;

import com.rezende.learn.entities.Episode;
import com.rezende.learn.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class WatchTimePK {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;

    public WatchTimePK() { }

    private WatchTimePK(User user, Episode episode) {
        this.user = user;
        this.episode = episode;
    }

    public static WatchTimePK from(User user, Episode episode) {
        return new WatchTimePK(user, episode);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        WatchTimePK that = (WatchTimePK) o;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getEpisode(), that.getEpisode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getEpisode());
    }
}