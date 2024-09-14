package com.trainingmug.foodieapp.service;

import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.exceptions.CustomerNotFoundException;
import com.trainingmug.foodieapp.model.Customer;
import com.trainingmug.foodieapp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository repository;

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

    @Override
    public Customer validateLogin(String email, String password) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = repository.findByEmailAndPassword(email,password);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Invalid Email or Password");
        return optionalCustomer.get();
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id : "+id);
        return optionalCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    @Override
    public Customer update(Customer updateCustomer) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.repository.findById(updateCustomer.getId());
        System.out.println(updateCustomer);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id : "+updateCustomer.getId());
        return repository.update(updateCustomer);
    }

    @Override
    public void delete(String id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id : "+id);
        repository.delete(optionalCustomer.get());
    }
}
