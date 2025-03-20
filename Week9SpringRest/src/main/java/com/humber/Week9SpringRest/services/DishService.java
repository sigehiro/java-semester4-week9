package com.humber.Week9SpringRest.services;

import com.humber.Week9SpringRest.models.Dish;
import com.humber.Week9SpringRest.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;
    // Constructor to initialize the DishRepository
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;

    }

    //get all dishes
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    //get dish by id
    public Dish getDishById(int id) {
        return dishRepository.findById(id).orElse(null);
    }

    //add dish
    public void addDish(Dish dish) {
        Dish existDish = dishRepository.findByName(dish.getName());
        // Check if the dish already exists
        if (existDish != null) {
            throw new IllegalStateException("Dish - " +dish.getName() + " already exists");
        }
        dishRepository.save(dish);

    }


    //update dish
    public void updateDish(int dishId,  Dish dish) {
        boolean existDish = dishRepository.existsById(dishId);
        // Check if the dish exists before updatin
        if (!existDish) {  // Dishが存在しない場合のチェック
            throw new IllegalStateException("Dish with id " +dishId + " does not exist");
        }
        dish.setId(dishId);
        dishRepository.save(dish);
    }


    //delete dish
    public void deleteDish(int dishId) {
        boolean existDish = dishRepository.existsById(dishId);
        // Check if the dish exists before attempting to delete it
        if(!existDish){
            throw new IllegalStateException("Dish with id " +dishId + " does not exist");
        }

        dishRepository.deleteById(dishId);
    }

}


