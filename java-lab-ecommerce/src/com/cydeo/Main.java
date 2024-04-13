package com.cydeo;

import com.cydeo.balance.Balance;
import com.cydeo.balance.CustomerBalance;
import com.cydeo.balance.GiftCartBalance;
import com.cydeo.category.Category;
import com.cydeo.discount.Discount;
import com.cydeo.order.Order;

import java.util.HashMap;
import java.util.Map;
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

        Cart cart = new Cart(customer);

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
                    Map<Product, Integer> map = new HashMap<>();
                    cart.setProductMap(map);
                    while (true){
                        System.out.println("Which product you want to add to your cart. For exist product selection Type : exist");

                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            try {
                                System.out.println("id: " + product.getId() + ", Price: " + product.getPrice()+ ", Category Name: "
                                + product.getCategoryName() + ", Stock: " + product.getRemainingStock() +
                                        ", Product delivery due : " + product.getDeliveryDueDate());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());;
                            }
                        }
                        String productId = scanner.nextLine();

                        try {
                            Product product = findProductById(productId);
                            if (!putItemToCartIfStockAvailable(cart, product)){
                                System.out.println("Stock is insufficient. Please try again");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());;
                        }

                        System.out.println("Do you want to add more product. Type Y for adding more, N for exist");
                        String decision = scanner.nextLine();
                        if (!decision.equals("Y")){
                            break;
                        }
                    }
                case 6:
                    System.out.println("Your Cart: ");
                    if (!cart.getProductMap().keySet().isEmpty()){
                        for (Product product:cart.getProductMap().keySet()){
                            System.out.println("Product name: " + product.getName() + ", Count: " + cart.getProductMap().get(product));
                        }
                    }else {
                        System.out.println("Your cart is empty");
                    }
                    break;
                case 7:
                    printOrdersByCustomerId(customer.getId());
                    break;
                case 8:
                    printAddressByCustomer(customer);
                    break;
                case 9:
                    System.exit(1);
                    break;
            }
        }
    }

    private static void printAddressByCustomer(Customer customer) {
        for (Address address : customer.getAddressList()) {
            System.out.println(" Street Name: " + address.getStreetName() +
                    " Street Number: " + address.getStreetNumber() + "ZipCode:  "
                    + address.getZipCode() + " State: " + address.getState());
        }
    }

    private static boolean putItemToCartIfStockAvailable(Cart cart, Product product) {
        System.out.println("Please provide product count: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Integer cartCount = cart.getProductMap().get(product);

        if (cartCount!=null && product.getRemainingStock() > cartCount+count){
            cart.getProductMap().put(product, cartCount+count);
            return true;
        } else if (product.getRemainingStock() >= count) {
            cart.getProductMap().put(product, count);
            return true;
        }else {
            return false;
        }


    }

    private static Product findProductById(String productId) throws Exception {
        for (Product product : StaticConstants.PRODUCT_LIST) {
            if (product.getId().toString().equals(productId)){
                return product;
            }
        }
        throw new Exception("Product not found! Please try again");
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

    private static void printOrdersByCustomerId(UUID customerId) {
        for (Order order : StaticConstants.ORDER_LIST) {
            if (order.getCustomerId().equals(customerId)){
                System.out.println("Order status: " + order.getOrderStatus() + " order amount " + order.getPaidAmount() + " order date " + order.getOrderDate());
            }
        }
    }

}
