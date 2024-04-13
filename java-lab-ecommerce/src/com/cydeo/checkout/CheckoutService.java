package com.cydeo.checkout;

import com.cydeo.Customer;

public interface CheckoutService {

    boolean checkout(Customer customer, Double totalAmount);
}
