package com.cydeo;

import com.cydeo.category.Category;
import com.cydeo.discount.Discount;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();

        Scanner scanner = new Scanner(System.in);
        //TODO Select user
        System.out.println("Select A Customer");
        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {
            System.out.println("Type " + i + " For Customer " + StaticConstants.CUSTOMER_LIST.get(i).getUserName()+" : ");
        }

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());

        //TODO Print menu options. (Menu should be printed until exit option is selected)
        while (true){

            System.out.println("What would you like to do? Just Type ID For Selection!");

            for (int i = 0; i < StaticConstants.MenuOptions.length; i++) {
                System.out.println("Type " + i + " For - " + StaticConstants.MenuOptions[i]+" : ");
            }
            int menuOption = scanner.nextInt();

            switch (menuOption){
                case 0: //list categories
                    for (Category category : StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category Code: " + category.generateCategoryCode() + ", Category Name: " + category.getName()
                                + ", Category Id: " + category.getId());
                    }
                    break;
                case 1: //list products
                    try{
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println("Product Name: " + product.getName()+ ", Product Id: " + product.getId() + ", Category Id: "+ product.getCategoryId()
                                    + ", Category Name: "+ product.getCategoryName());
                        }
                    }catch (Exception e){
                        System.out.println("Product Category could not printed because category is not found for product: " + e.getMessage().split(":")[1]);
                    }
                    break;
                case 2: //list discount
                    for (Discount discount : StaticConstants.DISCOUNTS_LIST) {
                        System.out.println("Discount Name: " + discount.getName() + ", Discount id: " + discount.getId()
                        + ", Discount Threshold Amount: " + discount.getThresholdAmount());
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

            }






        }


    }

}
