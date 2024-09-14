package com.trainingmug.foodieapp.repository;

import com.trainingmug.foodieapp.factory.Factory;
import com.trainingmug.foodieapp.model.Dish;
import com.trainingmug.foodieapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class DishRepository {
    List<Dish> dishList;

    public DishRepository(){
        this.dishList = Factory.getCsvReader().readDishesFromCsv();
    }
    public Dish save(Dish dish){
        this.dishList.add(dish);
        return dish;
    }
    public Optional<Dish> findById(String id){
        return this.dishList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }
}
