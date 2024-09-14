package com.trainingmug.foodieapp.controller;

import com.trainingmug.foodieapp.exceptions.DishExistsException;
import com.trainingmug.foodieapp.model.Dish;
import com.trainingmug.foodieapp.service.DishService;

public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService){
        this.dishService = dishService;
    }

    public Dish save(Dish dish) throws DishExistsException {
        return dishService.save(dish);
    }


}
