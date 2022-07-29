package com.cydeo;

import com.cydeo.category.Category;
import com.cydeo.category.Electronic;
import com.cydeo.category.Furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class DataGenerator {

    public static void createCustomer() {

        Address address1Customer1 = new Address("7925", "Jones Branch Drive", "Suite3300", "22102", "VA");
        Address address2Customer1 = new Address("825", "Georgetown Pkwy", "Suite5375", "22036", "VA");
        Address address1Customer2 = new Address("5924", "Lee Highway", "House", "22046", "VA");

        List<Address> customer1AddressList = new ArrayList<>();
        customer1AddressList.add(address1Customer1);
        customer1AddressList.add(address2Customer1);

        Customer customer1 = new Customer(UUID.randomUUID(), "ozzy", "ozzy@cydeo.com", customer1AddressList);
        Customer customer2 = new Customer(UUID.randomUUID(), "mike", "mike@gmail.com");

        CUSTOMER_LIST.add(customer1);
        CUSTOMER_LIST.add(customer2);

    }

    public static void createCategory() {

        Category category1 = new Electronic(UUID.randomUUID(), "Electronic");
        Category category2 = new Furniture(UUID.randomUUID(), "Furniture");
        Category category3 = new Furniture(UUID.randomUUID(), "SkinCare");

        CATEGORY_LIST.add(category1);
        CATEGORY_LIST.add(category2);
        CATEGORY_LIST.add(category3);

    }

    public static void createProduct() {

        Product product1 = new Product(UUID.randomUUID(), "PS5", 250.63, 7, 7, CATEGORY_LIST.get(0).getId());
        Product product2 = new Product(UUID.randomUUID(), "XBOX", 180.63, 15, 15, CATEGORY_LIST.get(0).getId());
        Product product3 = new Product(UUID.randomUUID(), "Chair", 50.63, 85, 85, CATEGORY_LIST.get(1).getId());
        Product product4 = new Product(UUID.randomUUID(), "Face Creme", 8.63, 250, 250, CATEGORY_LIST.get(2).getId());

        PRODUCT_LIST.add(product1);
        PRODUCT_LIST.add(product2);
        PRODUCT_LIST.add(product3);

    }

}
