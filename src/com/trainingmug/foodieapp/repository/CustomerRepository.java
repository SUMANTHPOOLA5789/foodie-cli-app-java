package com.trainingmug.foodieapp.repository;
import com.trainingmug.foodieapp.factory.Factory;
import com.trainingmug.foodieapp.model.Customer;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    List<Customer> customerList;

    public CustomerRepository() {
//        CsvReader csvReader = new CsvReader(); // Don't Create Objects We can Use Factory Class to Create Objects
//        CsvReader csvReader = Factory.getCsvReader();
        customerList = Factory.getCsvReader().readCustomersFromCsv(); //chain link
    }

    public Customer save(Customer customer){
        customerList.add(customer);
        return customer;
    }
    public Optional<Customer> findById(String id){
        return customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }



}
