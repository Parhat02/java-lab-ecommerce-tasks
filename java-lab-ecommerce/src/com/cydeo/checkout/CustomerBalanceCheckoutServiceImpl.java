package com.cydeo.checkout;

import com.cydeo.Customer;
import com.cydeo.StaticConstants;
import com.cydeo.balance.Balance;
import com.cydeo.balance.CustomerBalance;

import java.util.UUID;

public class CustomerBalanceCheckoutServiceImpl implements CheckoutService{
    @Override
    public boolean checkout(Customer customer, Double totalAmount) {
        CustomerBalance customerBalance = findCustomerBalance(customer.getId());
        double finalBalance = customerBalance.getBalance() - totalAmount;
        if (finalBalance > 0){
            customerBalance.setBalance(finalBalance);
            return true;
        }
        return false;
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
}
