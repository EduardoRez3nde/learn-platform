package com.rezende.learn.entities;

import com.rezende.learn.entities.pk.WatchTimePK;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_watch_time")
public class WatchTime {

    @EmbeddedId
    private WatchTimePK id = new WatchTimePK();

    private Long seconds;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public WatchTime() {}

    private WatchTime(User user, Episode episode) {
        id.setUser(user);
        id.setEpisode(episode);
    }

    public static WatchTime from(User user, Episode episode) {
        return new WatchTime(user, episode);
    }

    public User getUser() {
        return id.getUser();
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public Episode getEpisode() {
        return id.getEpisode();
    }

    public void setEpisode(Episode episode) {
        id.setEpisode(episode);
    }

    public WatchTimePK getId() {
        return id;
    }

    public void setId(WatchTimePK id) {
        this.id = id;
    }

    public Long getSeconds() {
        return seconds;
    }

    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WatchTime watchTime = (WatchTime) o;
        return Objects.equals(id, watchTime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}