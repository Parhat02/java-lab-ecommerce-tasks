package com.cydeo.balance;

import java.util.UUID;

public class GiftCardBalance {

    public GiftCardBalance(Double balance, UUID customerId) {
        this(balance, customerId);
    }

    @Override
    public Double addBalance(Double additionalAmount) {
        double promotionAmount = additionalAmount * 10 / 100;
        setBalance(getBalance() + additionalAmount + promotionAmount);
        return getBalance();
    }

}
