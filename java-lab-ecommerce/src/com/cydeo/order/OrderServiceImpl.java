package com.cydeo.order;

import com.cydeo.Cart;
import com.cydeo.StaticConstants;
import com.cydeo.checkout.CheckoutService;
import com.cydeo.checkout.CustomerBalanceCheckoutServiceImpl;
import com.cydeo.checkout.MixPaymentCheckoutServiceImpl;
import com.cydeo.discount.Discount;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class OrderServiceImpl implements OrderService{

    @Override
    public String placeOrder(Cart cart) {
        double amountAfterDiscount = cart.calculateCartTotalAmount();

        if (cart.getDiscountId() != null){
            Discount discount = null;
            try {
                discount = findDiscountById(cart.getDiscountId());
                amountAfterDiscount = discount.calculationCartAmountAfterDiscount(amountAfterDiscount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("which payment option you would like to choose, Type 1 : customer balance, Type 2 : Mix (gift card + customer balance)");
        int paymentType = scanner.nextInt();
        boolean checkoutResult = false;
        switch (paymentType){
            case 1:
                CheckoutService customerBalanceCheckout = new CustomerBalanceCheckoutServiceImpl();
                checkoutResult = customerBalanceCheckout.checkout(cart.getCustomer(), amountAfterDiscount);
                break;
            case 2:
                CheckoutService mixPaymentCheckout = new MixPaymentCheckoutServiceImpl();
                checkoutResult = mixPaymentCheckout.checkout(cart.getCustomer(), amountAfterDiscount);
                break;
        }

        if (checkoutResult) {
            Order order = new Order(UUID.randomUUID(), LocalDateTime.now(), cart.calculateCartTotalAmount(), amountAfterDiscount,
                    cart.calculateCartTotalAmount()-amountAfterDiscount, cart.getCustomer().getId(),
                    "Placed", cart.getProductMap().keySet());
            StaticConstants.ORDER_LIST.add(order);
            return "Order has been placed successfully";
        }else {
            return "Balance is insufficient. Please add money to your one of balances and try again.";
        }

    }

    private Discount findDiscountById(UUID discountId) throws Exception {
        for (Discount discount : StaticConstants.DISCOUNTS_LIST){
            if (discount.getId().toString().equals(discountId.toString())){
                return discount;
            }
        }
        throw new Exception("Discount couldn't found!");
    }
}
