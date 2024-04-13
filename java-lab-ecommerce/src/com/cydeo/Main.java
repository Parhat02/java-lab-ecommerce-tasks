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
        System.out.println("What would you like to do? Just Type ID For Selection!");

        for (int i = 0; i < StaticConstants.MenuOptions.length; i++) {
            System.out.println("Type " + i + " For - " + StaticConstants.MenuOptions[i]+" : ");
        }
        int menuOption = scanner.nextInt();


//        for (int i = 0; i < StaticConstants.CATEGORY_LIST.size(); i++) {
//            System.out.println("Type " + i + " For Category " + StaticConstants.CATEGORY_LIST.get(i).getName()+" : ");
//        }



    }

}
