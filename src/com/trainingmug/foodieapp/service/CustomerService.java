package com.trainingmug.foodieapp.service;

import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.exceptions.CustomerNotFoundException;
import com.trainingmug.foodieapp.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer) throws CustomerExistException;
    Customer validateLogin(String email,String password) throws CustomerNotFoundException;
    Customer getCustomerById(String id) throws CustomerNotFoundException;
    List<Customer> getAllCustomers();
    Customer update(Customer updateCustomer) throws CustomerNotFoundException;
    void delete(String id) throws CustomerNotFoundException;
}
