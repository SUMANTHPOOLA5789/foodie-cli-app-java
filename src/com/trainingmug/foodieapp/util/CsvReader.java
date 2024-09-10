package com.trainingmug.foodieapp.util;

import com.trainingmug.foodieapp.model.Customer;

import java.io.BufferedReader;
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
        }
        return customerList;
    }

}
