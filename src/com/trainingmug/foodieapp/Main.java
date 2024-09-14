package com.trainingmug.foodieapp;

import com.trainingmug.foodieapp.controller.CustomerController;
import com.trainingmug.foodieapp.factory.Factory;
import com.trainingmug.foodieapp.repository.CustomerRepository;
import com.trainingmug.foodieapp.service.CustomerService;
import com.trainingmug.foodieapp.service.CustomerServiceImpl;
import com.trainingmug.foodieapp.ui.Menu;

public class Main {
    public static void main(String[] args) {
/*
        CustomerRepository repository = new CustomerRepository();
        CustomerService service =  new CustomerServiceImpl(repository);//CustomerServiceImpl Depend on CustomerRepository Object
        CustomerController controller = new CustomerController(service);//CustomerController Depend on CustomerService Object
*/
        //We Can Prepare Above Object in Factory Class
//        CustomerController controller = Factory.getCustomerController();
        Menu menu = new Menu();
        menu.displayMenu();
    }
}