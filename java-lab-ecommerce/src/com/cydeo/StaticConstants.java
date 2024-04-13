package com.cydeo;

import com.cydeo.balance.Balance;
import com.cydeo.category.Category;

import java.util.ArrayList;
import java.util.List;

public class StaticConstants {

    public static final List<Customer> CUSTOMER_LIST = new ArrayList<>();
    public static final List<Category> CATEGORY_LIST = new ArrayList<>();
    public static final List<Product> PRODUCT_LIST = new ArrayList<>();
    public static final List<Balance> CUSTOMER_BALANCE_LIST = new ArrayList<>();
    public static final List<Balance> GIFT_CARD_BALANCE_LIST = new ArrayList<>();

    public static final String[] MenuOptions = new String[]{"List Categories","List Products","List Discount","See Balance","Add Balance",
                "Place an order","See Cart","See order details","See your address","Close App"};


}
