package com.cydeo;

import com.cydeo.balance.Balance;
import com.cydeo.balance.CustomerBalance;
import com.cydeo.balance.GiftCartBalance;
import com.cydeo.category.Category;
import com.cydeo.category.Electronic;
import com.cydeo.category.Furniture;
import com.cydeo.discount.AmountBasedDiscount;
import com.cydeo.discount.Discount;
import com.cydeo.discount.RateBasedDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {

    public static void createCustomer() {

        Address address1Customer1 = new Address("7925", "Jones Branch Drive", "Suite3300", "22102", "VA");
        Address address2Customer1 = new Address("825", "Georgetown Pkwy", "Suite5375", "22036", "VA");
        Address address3Customer1 = new Address("5924", "Lee Highway", "House", "22046", "VA");

        List<Address> customer1AddressList = new ArrayList<>();
        customer1AddressList.add(address1Customer1);
        customer1AddressList.add(address2Customer1);
        customer1AddressList.add(address3Customer1);

        Customer customer1 = new Customer(UUID.randomUUID(), "ozzy", "ozzy@cydeo.com", customer1AddressList);
        Customer customer2 = new Customer(UUID.randomUUID(), "mike", "mike@gmail.com");

        StaticConstants.CUSTOMER_LIST.add(customer1);
        StaticConstants.CUSTOMER_LIST.add(customer2);

    }

    public static void createCategory() {

        Category category1 = new Electronic(UUID.randomUUID(), "Electronic");
        Category category2 = new Furniture(UUID.randomUUID(), "Furniture");
        Category category3 = new Furniture(UUID.randomUUID(), "SkinCare");

        StaticConstants.CATEGORY_LIST.add(category1);
        StaticConstants.CATEGORY_LIST.add(category2);
        StaticConstants.CATEGORY_LIST.add(category3);

    }

    public static void createProduct() {

        Product product1 = new Product(UUID.randomUUID(), "PS5", 250.63, 7, 7, StaticConstants.CATEGORY_LIST.get(0).getId());
        Product product2 = new Product(UUID.randomUUID(), "XBOX", 180.63, 15, 15, StaticConstants.CATEGORY_LIST.get(0).getId());
        Product product3 = new Product(UUID.randomUUID(), "Chair", 50.63, 85, 85, StaticConstants.CATEGORY_LIST.get(1).getId());
        Product product4 = new Product(UUID.randomUUID(), "Face Creme", 8.63, 250, 250, StaticConstants.CATEGORY_LIST.get(2).getId());
        Product product5 = new Product(UUID.randomUUID(), "Milk", 2.25, 150, 125, UUID.randomUUID());

        StaticConstants.PRODUCT_LIST.add(product1);
        StaticConstants.PRODUCT_LIST.add(product2);
        StaticConstants.PRODUCT_LIST.add(product3);
        StaticConstants.PRODUCT_LIST.add(product4);
        StaticConstants.PRODUCT_LIST.add(product5);

    }

    public static void createBalance() {

        Balance customerBalance = new CustomerBalance(StaticConstants.CUSTOMER_LIST.get(0).getId(), 45000.00);
        Balance giftCardBalance = new GiftCartBalance(StaticConstants.CUSTOMER_LIST.get(1).getId(), 50000.00);

        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);

    }

    public static void createDiscount(){

        Discount amountBasedDiscount = new AmountBasedDiscount(UUID.randomUUID(), "Buy 250 Free 50", 250.00, 50.00);
        Discount rateBasedDiscount = new RateBasedDiscount(UUID.randomUUID(), "Buy 500 Free %15", 500.00, 15.00);

        StaticConstants.DISCOUNTS_LIST.add(amountBasedDiscount);
        StaticConstants.DISCOUNTS_LIST.add(rateBasedDiscount);
    }

}
