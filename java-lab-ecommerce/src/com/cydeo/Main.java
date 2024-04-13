package com.cydeo;

import com.cydeo.balance.Balance;
import com.cydeo.balance.CustomerBalance;
import com.cydeo.balance.GiftCartBalance;
import com.cydeo.category.Category;
import com.cydeo.discount.Discount;

import java.util.Scanner;
import java.util.UUID;

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
                case 3: //List Balance
                    CustomerBalance cBalance = findCustomerBalance(customer.getId());
                    GiftCartBalance gBalance = findGiftCardBalance(customer.getId());
                    double totalBalance = cBalance.getBalance() + gBalance.getBalance();
                    System.out.println("Total Balance: " + totalBalance);
                    System.out.println("Customer Balance: " + cBalance.getBalance());
                    System.out.println("Gift Card Balance: " + gBalance.getBalance());
                    break;
                case 4:
                    CustomerBalance customerBalance = findCustomerBalance(customer.getId());
                    GiftCartBalance giftCardBalance = findGiftCardBalance(customer.getId());
                    System.out.println("Which account would you like to add?");
                    System.out.println("Type 1 For Customer Balance: " + customerBalance.getBalance());
                    System.out.println("Type 2 For Gift Card Balance: " + giftCardBalance.getBalance());
                    int balanceSelection = scanner.nextInt();
                    System.out.println("How much would you like to add?");
                    double additionalAmount = scanner.nextInt();

                    switch (balanceSelection){
                        case 1:
                            customerBalance.addBalance(additionalAmount);
                            System.out.println("New Customer Balance: " + customerBalance.getBalance());
                            break;
                        case 2:
                            giftCardBalance.addBalance(additionalAmount);
                            System.out.println("New Customer Balance: " + giftCardBalance.getBalance());
                            break;
                    }
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

    private static CustomerBalance findCustomerBalance(UUID customerId) {

        for (Balance customerBalance : StaticConstants.CUSTOMER_BALANCE_LIST){
            if (customerBalance.getCustomerId().equals(customerId)){
                return (CustomerBalance) customerBalance;
            }
        }
        CustomerBalance newCustomerBalance = new CustomerBalance(customerId, 0d);
        StaticConstants.CUSTOMER_BALANCE_LIST.add(newCustomerBalance);
        return newCustomerBalance;
    }

    private static GiftCartBalance findGiftCardBalance(UUID customerId) {

        for (Balance giftCardBalance : StaticConstants.GIFT_CARD_BALANCE_LIST) {
            if (giftCardBalance.getCustomerId().equals(customerId)){
                return (GiftCartBalance) giftCardBalance;
            }
        }
        GiftCartBalance newGifCardBalance = new GiftCartBalance(customerId, 0d);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(newGifCardBalance);
        return newGifCardBalance;
    }

}
