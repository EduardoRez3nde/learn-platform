package com.rezende.learn.entities;

import com.rezende.learn.entities.pk.FavoritePK;
import com.rezende.learn.entities.pk.LikePK;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_favorite")
public class Favorite {

    @EmbeddedId
    private FavoritePK id = new FavoritePK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Favorite() {}

    private Favorite(User user, Course course) {
        id.setUser(user);
        id.setCourse(course);
    }

    public static Favorite from(User user, Course course) {
        return new Favorite(user, course);
    }

    public User getUser() {
        return id.getUser();
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public Course getCourse() {
        return id.getCourse();
    }

    public void setCourse(Course course) {
        id.setCourse(course);
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }
}