package com.trainingmug.foodieapp.service;

import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.model.Customer;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistException;
}
