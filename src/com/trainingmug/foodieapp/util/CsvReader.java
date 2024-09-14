package com.trainingmug.foodieapp.util;

import com.trainingmug.foodieapp.model.Customer;
import com.trainingmug.foodieapp.model.Dish;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<Customer> readCustomersFromCsv(){
        String CUSTOMER_CSV_PATH = "D:\\FULL STACK DEVELOPER _ WORK SPACE\\Git\\foodie-cli-app-java\\data\\customers.csv";
        List<Customer> customerList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_CSV_PATH))){
            br.readLine();
            String cvsSplitBy = ",";
            while((line=br.readLine())!= null){
                String[] data = line.split(cvsSplitBy);
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customerList.add(customer);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path : "+CUSTOMER_CSV_PATH);
            System.exit(0);
        }
        return customerList;
    }
    public List<Dish> readDishesFromCsv(){
        String DISHES_CSV_PATH = "D:\\FULL STACK DEVELOPER _ WORK SPACE\\Git\\foodie-cli-app-java\\data\\dishes.csv";
        List<Dish> dishList = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))){
            br.readLine();
            String csvSplitBy = ",";
            while ((line = br.readLine()) != null){
                String[] data = line.split(csvSplitBy);
                Dish dish = new Dish();
                dish.setId(data[0])
                        .setName(data[1])
                        .setDescription(data[2])
                        .setPrice(Double.parseDouble(data[3]));
                dishList.add(dish);
            }

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path : "+DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishList;
    }

}
