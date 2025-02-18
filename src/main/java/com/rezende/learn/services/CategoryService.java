package com.rezende.learn.services;

import com.rezende.learn.dto.CategoryAndCourseDTO;
import com.rezende.learn.dto.CategoryDTO;
import com.rezende.learn.entities.Category;
import com.rezende.learn.repositories.CategoryRepository;
import com.rezende.learn.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public CategoryAndCourseDTO findById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id %s not found", id));
        return CategoryAndCourseDTO.from(category);
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(CategoryDTO::of);
    }
}
