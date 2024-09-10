package com.trainingmug.foodieapp.factory;

import com.trainingmug.foodieapp.controller.CustomerController;
import com.trainingmug.foodieapp.repository.CustomerRepository;
import com.trainingmug.foodieapp.service.CustomerService;
import com.trainingmug.foodieapp.service.CustomerServiceImpl;
import com.trainingmug.foodieapp.util.CsvReader;

public class Factory {

    public static CsvReader getCsvReader(){
        return new CsvReader();
    }
    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }
    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());
    }
    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }

}
