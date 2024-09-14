package com.trainingmug.foodieapp.ui;

import com.trainingmug.foodieapp.controller.CustomerController;
import com.trainingmug.foodieapp.controller.DishController;
import com.trainingmug.foodieapp.exceptions.DishExistsException;
import com.trainingmug.foodieapp.factory.Factory;
import com.trainingmug.foodieapp.model.Dish;

import java.util.Scanner;

public class DishesMenu extends Menu{
    private final DishController dishController;

    public DishesMenu(){
        this.dishController = Factory.getDishController();
    }

    public void displayMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            while (true){
                displayMenuHeader("WELCOME TO DISHES SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Dish");
                System.out.println("2. View All Dish items");
                System.out.println("3. Search Dish");
                System.out.println("4. Update Dish");
                System.out.println("5. Delete Dish");
                System.out.println("6. Exit");
                System.out.println("Please enter your choice (1-6)");
                int input = scanner.nextInt();
                switch (input){
                    case 1-> newDishForm();
                    case 6->{
                        System.out.println("Thank you, see you again");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid input. Please enter the valid input from (1-6)");
                }
            }
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }
    public void newDishForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Description");
            String description = scanner.nextLine();
            System.out.println("Enter Price");
            double price = scanner.nextDouble();
            Dish dish = new Dish();
                dish.setId(id)
                    .setName(name)
                    .setDescription(description)
                    .setPrice(price);
            Dish savedDish = dishController.save(dish);
            System.out.println("Dish Added Successfully");
            displayDish(savedDish);

        }catch(DishExistsException e){
            System.out.println(e.getMessage());

        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }
    public void displayDish(Dish dish){
        displayMenuHeader("Dish Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-10s\n",dish.getId(),dish.getName(),dish.getDescription(),String.format("$%.2f",dish.getPrice()));
    }

}
