package com.trainingmug.foodieapp.ui;

import com.trainingmug.foodieapp.controller.CustomerController;
import com.trainingmug.foodieapp.exceptions.CustomerExistException;
import com.trainingmug.foodieapp.exceptions.CustomerNotFoundException;
import com.trainingmug.foodieapp.factory.Factory;
import com.trainingmug.foodieapp.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu extends Menu{

    private final CustomerController customerController;

    public CustomerMenu(){
        this.customerController = Factory.getCustomerController();
    }


    public void displayMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            while(true){
                displayMenuHeader("WELCOME TO CUSTOMER SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login (Existing Customer)");
                System.out.println("3. Search Customer By Id");
                System.out.println("4. Display All Customers");
                System.out.println("5. Update Customer");
                System.out.println("6. Delete Customer");
                System.out.println("7. Exit");
                System.out.println("Please enter your choice (1-7)");
                int input = scanner.nextInt();
                switch (input){
                    case 1 -> registerForm();
                    case 2 -> loginForm();
                    case 3 -> searchByIdForm();
                    case 4 -> displayAllCustomers();
                    case 5 -> updateCustomerForm();
                    case 6 -> deleteCustomerForm();
                    case 7 ->{
                        System.out.println("Thank you , see you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid input. Please enter the valid input from (1-7)");
                }
            }
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }

    public void registerForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please register entering the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Email");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();

            Customer customer = new Customer();
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);
            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration Successful");
            displayCustomerDetails(savedCustomer);
        }catch (CustomerExistException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            registerForm();
        }
    }
    public void displayCustomerDetails(Customer customer){
        displayMenuHeader("Customer Details");
        System.out.printf("%-10s %-30s %-80s %-30s \n","Id","Name","Email","Password");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s \n",customer.getId(),customer.getName(),customer.getEmail(),"*".repeat(customer.getPassword().length()));
        System.out.println();
    }
    public void loginForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please login entering the following details\n");
            System.out.println("Enter Email");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            Customer existingCustomer = customerController.validateLogin(email,password);
            System.out.println("Login Success :");
            System.out.println("Welcome Mr : "+ existingCustomer.getName());
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }
    public void searchByIdForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search customer by id\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Customer customer = customerController.getCustomerById(id);
            displayCustomerDetails(customer);
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void displayAllCustomers(){
        try {
            List<Customer> customerList = customerController.getAllCustomers();
            displayMenuHeader("Customers");
            System.out.printf("%-10s %-30s %-80s %-30s \n","Id","Name","Email","Password");
            printDashLine();
            customerList.forEach(customer ->
                    System.out.printf("%-10s %-30s %-80s %-30s \n",customer.getId(),customer.getName(),customer.getEmail(),"*".repeat(customer.getPassword().length()))
            );
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }
    public void updateCustomerForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details \n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Email");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            Customer customer = new Customer();
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);
            Customer updateCustomer = customerController.update(customer);
            System.out.println("Customer Updated Successfully");
            displayCustomerDetails(updateCustomer);
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }
    public void deleteCustomerForm() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            customerController.delete(id);
            System.out.println("Customer Deleted Successfully");
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
