package com.cydeo.checkout;

import com.cydeo.Customer;
import com.cydeo.StaticConstants;
import com.cydeo.balance.Balance;
import com.cydeo.balance.CustomerBalance;
import com.cydeo.balance.GiftCartBalance;

import java.util.UUID;

public class MixPaymentCheckoutServiceImpl implements CheckoutService{
    @Override
    public boolean checkout(Customer customer, Double totalAmount) {

        GiftCartBalance giftCartBalance = findGiftCardBalance(customer.getId());

        double giftBalance = giftCartBalance.getBalance() - totalAmount;
        if (giftBalance > 0){
            giftCartBalance.setBalance(giftBalance);
        }else {
            CustomerBalance customerBalance = findCustomerBalance(customer.getId());
            double mixBalance = giftCartBalance.getBalance() + customerBalance.getBalance() - totalAmount;
            if (mixBalance > 0) {
                giftCartBalance.setBalance(0d);
                customerBalance.setBalance(mixBalance);
                return true;
            }
        }
        return false;
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
