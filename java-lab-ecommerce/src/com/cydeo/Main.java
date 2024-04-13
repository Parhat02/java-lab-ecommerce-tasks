package com.cydeo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();

        Scanner scanner = new Scanner(System.in);
        //TODO Select user
        System.out.println("Select A Customer");
        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {
            System.out.println("Type " + i + " For Customer " + StaticConstants.CUSTOMER_LIST.get(i).getUserName()+" : ");
        }

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());

        //TODO Print menu options. (Menu should be printed until exit option is selected)



    }

}
