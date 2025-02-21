package com.rezende.learn.repositories;

import com.rezende.learn.dto.CategoryDTO;
import com.rezende.learn.entities.Category;
import com.rezende.learn.factoryMethods.CategoryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTests {

    private UUID existingCategoryId;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        CategoryDTO dto = CategoryFactory.createCategoryDTO();
        Category category = CategoryFactory.createCategory(dto);
        category = categoryRepository.save(category);
        existingCategoryId = category.getId();
    }

    @Test
    public void findByIdShouldReturnObjectWhenIdExists() {
        Optional<Category> result = categoryRepository.findById(existingCategoryId);
        Assertions.assertTrue(result.isPresent());
    }
}
