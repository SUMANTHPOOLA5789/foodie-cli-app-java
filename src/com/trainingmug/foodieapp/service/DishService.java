package com.trainingmug.foodieapp.service;

import com.trainingmug.foodieapp.exceptions.DishExistsException;
import com.trainingmug.foodieapp.model.Dish;

public interface DishService {

    Dish save(Dish dish) throws DishExistsException;
}
