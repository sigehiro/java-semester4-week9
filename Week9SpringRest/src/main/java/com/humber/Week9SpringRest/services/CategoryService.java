package com.humber.Week9SpringRest.services;

import com.humber.Week9SpringRest.models.Category;
import com.humber.Week9SpringRest.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    // Constructor to initialize the CategoryRepository
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    // Get a category by its name
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
