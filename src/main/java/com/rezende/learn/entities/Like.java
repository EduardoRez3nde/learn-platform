package com.rezende.learn.entities;

import com.rezende.learn.entities.pk.LikePK;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_like")
public class Like {

    @EmbeddedId
    private LikePK id = new LikePK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Like() {}

    private Like(User user, Course course) {
        id.setUser(user);
        id.setCourse(course);
    }

    public static Like from(User user, Course course) {
        return new Like(user, course);
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

    public LikePK getId() {
        return id;
    }
}