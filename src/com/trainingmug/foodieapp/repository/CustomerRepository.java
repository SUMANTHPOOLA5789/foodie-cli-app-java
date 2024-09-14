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
        this.customerList = Factory.getCsvReader().readCustomersFromCsv(); //chain link
    }

    public Customer save(Customer customer){
        this.customerList.add(customer);
        return customer;
    }
    public Optional<Customer> findById(String id){
        return this.customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }
    public Optional<Customer> findByEmailAndPassword(String email,String password){
        return this.customerList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email)&&customer.getPassword().equals(password)).findFirst();
    }
    public List<Customer> getAllCustomers() {
        return this.customerList;
    }
    public Customer update(Customer updateCustomer) {
        Optional<Customer> optionalCustomer = this.customerList.stream()
                .filter(customer -> customer.getId().equals(updateCustomer.getId()))
                .findFirst()
                .map(
                customer ->{
                    customer.setName(updateCustomer.getName())
                            .setEmail(updateCustomer.getEmail())
                            .setPassword(updateCustomer.getPassword());
                    return customer;
                });
        return optionalCustomer.orElse(null);
    }

    public void delete(Customer customer) {
        this.customerList.remove(customer);
    }
}
