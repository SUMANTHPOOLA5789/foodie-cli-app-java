package com.trainingmug.foodieapp.controller;

import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.model.Customer;
import com.trainingmug.foodieapp.service.CustomerService;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistException {
        return customerService.save(customer);
    }


}
