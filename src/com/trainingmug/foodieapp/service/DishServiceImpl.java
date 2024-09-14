package com.trainingmug.foodieapp.service;

import com.trainingmug.foodieapp.exceptions.DishExistsException;
import com.trainingmug.foodieapp.model.Dish;
import com.trainingmug.foodieapp.repository.DishRepository;

import java.util.Optional;

public class DishServiceImpl implements DishService{
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository repository){
        this.dishRepository = repository;
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> optionalDish = dishRepository.findById(dish.getId());
        if(optionalDish.isPresent())
            throw new DishExistsException("Dish Already Exists with this id : "+dish.getId());
        return dishRepository.save(dish);
    }
}
