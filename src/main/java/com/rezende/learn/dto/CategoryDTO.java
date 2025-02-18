package com.rezende.learn.dto;

import com.rezende.learn.entities.Category;

import java.util.UUID;

public class CategoryDTO {

    private UUID id;
    private String name;
    private Integer position;

    public CategoryDTO() { }

    private CategoryDTO(UUID id, String name, Integer position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public static CategoryDTO from(UUID id, String name, Integer position) {
        return new CategoryDTO(id, name, position);
    }

    public static CategoryDTO of(Category category) {
        return new CategoryDTO(category.getId(), category.getName(), category.getPosition());
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
