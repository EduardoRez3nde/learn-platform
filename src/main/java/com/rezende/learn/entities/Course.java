package com.rezende.learn.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String synopsis;
    private String thumbnailUrl;
    private boolean featured;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes = new ArrayList<>();

    @OneToMany(mappedBy = "id.course", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Like> likes = new HashSet<>();

    @OneToMany(mappedBy = "id.course", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Favorite> favorites = new HashSet<>();

    public Course() { }

    private Course(
            UUID id,
            String name,
            String synopsis,
            String thumbnailUrl,
            boolean featured,
            Category category
    ) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
        this.thumbnailUrl = thumbnailUrl;
        this.featured = featured;
        this.category = category;
        this.episodes = episodes;
    }

    public static Course from(
            UUID id,
            String name,
            String synopsis,
            String thumbnailUrl,
            boolean featured,
            Category category
    ) {
        return new Course(id, name, synopsis, thumbnailUrl, featured, category);
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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
