package com.cydeo.balance;

import java.util.UUID;

public class GiftCartBalance extends Balance{
    public GiftCartBalance(UUID customerId, Double balance) {
        super(customerId, balance);
    }

    @Override
    public Double addBalance(Double amount) {
        Double promotionAmount = amount * 0.1;
        setBalance(getBalance()+amount+promotionAmount);
        return null;
    }
}
