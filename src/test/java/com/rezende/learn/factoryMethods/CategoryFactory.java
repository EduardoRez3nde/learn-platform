package com.rezende.learn.factoryMethods;

import com.rezende.learn.dto.CategoryDTO;
import com.rezende.learn.entities.Category;

public class CategoryFactory {

    public static Category createCategory(CategoryDTO entity) {
        return Category.from(entity.getName(), entity.getPosition());
    }

    public static CategoryDTO createCategoryDTO() {
        return CategoryDTO.of("Programação", 1);
    }
}
