package com.humber.Week9SpringRest.repositories;

import com.humber.Week9SpringRest.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Method to find a category by its name
    Category findByName(String name);
}
