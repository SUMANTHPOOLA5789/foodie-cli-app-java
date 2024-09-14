package com.trainingmug.foodieapp.controller;

import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.exceptions.CustomerNotFoundException;
import com.trainingmug.foodieapp.model.Customer;
import com.trainingmug.foodieapp.service.CustomerService;

import java.util.List;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistException {
        return customerService.save(customer);
    }
    public Customer validateLogin(String email,String password) throws CustomerNotFoundException {
        return customerService.validateLogin(email,password);
    }
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    public Customer update(Customer updateCustomer) throws CustomerNotFoundException {
        return customerService.update(updateCustomer);
    }
    public void delete(String id) throws CustomerNotFoundException {
        customerService.delete(id);
    }
}
