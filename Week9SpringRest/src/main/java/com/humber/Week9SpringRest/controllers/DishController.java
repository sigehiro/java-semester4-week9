package com.humber.Week9SpringRest.controllers;


import com.humber.Week9SpringRest.models.Category;
import com.humber.Week9SpringRest.models.Dish;
import com.humber.Week9SpringRest.services.CategoryService;
import com.humber.Week9SpringRest.services.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/api")
public class DishController {

    private final DishService dishService;
    private final CategoryService categoryService;

    //constructor
    public DishController(DishService dishService, CategoryService categoryService) {
        this.dishService = dishService;
        this.categoryService = categoryService;
    }

    //get all dishes
//    データベースからすべての料理（Dish）を取得し、
//    リストとして返します。成功した場合、HTTPステータス200と共に料理のリストを返します。
//    データベースからすべての料理（Dish）を取得し、リストとして返します。
//    成功した場合、HTTPステータス200と共に料理のリストを返します。
    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getAllDishes() {
        return ResponseEntity.ok(dishService.getAllDishes());
    }

    //get dish id
//    指定されたIDに基づいて特定の料理を取得します。
//    成功した場合、HTTPステータス200と共にその料理の詳細を返します。
    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable int id) {
        return ResponseEntity.ok(dishService.getDishById(id));
    }

    //add dish
    // ここの書き方、内容を理解しておく。

//    新しい料理をデータベースに追加します。リクエストボディに含まれる料理オブジェクトを受け取り、
//    カテゴリが存在するか確認し、存在すればそのカテゴリを設定します。
//    成功した場合、HTTPステータス200と共に成功メッセージを返します。
    @PostMapping("/dishes")
    public ResponseEntity<String> addDish(@RequestBody Dish dish) {
        Category existingCategory = categoryService.getCategoryByName(dish.getCategory().getName());

        if (existingCategory != null) {
            dish.setCategory(existingCategory);
        }

        try {
            dishService.addDish(dish);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
        return ResponseEntity.ok("Dish " + dish.getName() + " added successfully");
    }

//    指定されたIDの料理を更新します。リクエストボディに含まれる新しい料理情報で既存の料理を上書きします。
//    成功した場合、HTTPステータス200と共に成功メッセージを返します。
    @PutMapping("/dishes/{id}")
    public ResponseEntity<String> updateDish(@PathVariable int id, @RequestBody Dish dish) {
        Category existingCategory = categoryService.getCategoryByName(dish.getCategory().getName());

        if (existingCategory != null) {
            dish.setCategory(existingCategory);
        }

        try {
            dishService.updateDish(id, dish);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
        return ResponseEntity.ok("Dish " + dish.getName() + " updated successfully");
    }


    //delete dish
//    指定されたIDの料理をデータベースから削除します。
//    成功した場合、HTTPステータス200と共に削除成功のメッセージを返します。
    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable int id) {

        try {
            dishService.deleteDish(id);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
        return ResponseEntity.ok("Dish with id " + id + " deleted successfully");
    }


}
