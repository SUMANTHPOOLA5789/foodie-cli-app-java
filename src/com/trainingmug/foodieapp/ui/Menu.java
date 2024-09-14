package com.trainingmug.foodieapp.ui;

import java.util.Scanner;

public class Menu {

    public void displayMenu(){
        try {
            Scanner sc = new Scanner(System.in);
            while (true){
                displayMenuHeader("WELCOME TO FOODIE APP");
                System.out.println();
                System.out.println("Please select Options !");
                System.out.println("1. Customer Section");
                System.out.println("3. Dishes Section");
                System.out.println("5. Exit");
                System.out.println("Please enter your choice (1-5)");
                int input = sc.nextInt();
                switch (input){
                    case 1 -> new CustomerMenu().displayMenu();
                    case 3 -> new DishesMenu().displayMenu();
                    case 5 -> {
                        System.out.println("Thanks for choosing Foodie App, see you again !");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input. Please enter the valid input from(1-7)");
                }
            }
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }
    public void displayMenuHeader(String menuHeader){
        printDashLine();
        String spaces = new String(new char[70]).replace('\0',' ');
        System.out.printf("%-70s %-10s %-70s \n",spaces,menuHeader,spaces);
        printDashLine();
    }
    public void printDashLine(){
        String dashesLine = new String( new char[150] ).replace('\0','-');
        System.out.println(dashesLine);
    }

}
