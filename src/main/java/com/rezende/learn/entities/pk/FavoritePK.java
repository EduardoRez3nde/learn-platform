package com.rezende.learn.entities.pk;

import com.rezende.learn.entities.Course;
import com.rezende.learn.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class FavoritePK {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public FavoritePK() { }

    private FavoritePK(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public static FavoritePK from(User user, Course course) {
        return new FavoritePK(user, course);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FavoritePK that = (FavoritePK) o;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getCourse(), that.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getCourse());
    }
}