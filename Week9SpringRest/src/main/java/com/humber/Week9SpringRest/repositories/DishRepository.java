package com.humber.Week9SpringRest.repositories;

import com.humber.Week9SpringRest.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    // Method to find a dish by its name
    Dish findByName(String name);

}
