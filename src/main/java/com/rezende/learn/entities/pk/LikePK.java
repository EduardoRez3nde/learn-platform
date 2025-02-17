package com.rezende.learn.entities.pk;

import com.rezende.learn.entities.Course;
import com.rezende.learn.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class LikePK {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public LikePK() {
    }

    public LikePK(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public static LikePK from(User user, Course course) {
        return new LikePK(user, course);
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
        LikePK likePK = (LikePK) o;
        return Objects.equals(getUser(), likePK.getUser()) && Objects.equals(getCourse(), likePK.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getCourse());
    }
}