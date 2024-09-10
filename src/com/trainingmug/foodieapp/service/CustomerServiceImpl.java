package com.trainingmug.foodieapp.service;

import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.model.Customer;
import com.trainingmug.foodieapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistException {
        Optional<Customer> op = repository.findById(customer.getId());
        if(op.isPresent()){
            throw new CustomerExistException("Customer Already Exists with this Id : "+customer.getId());
        }
        return repository.save(customer);
    }
}
