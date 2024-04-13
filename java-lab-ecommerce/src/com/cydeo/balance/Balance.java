package com.cydeo.balance;

import java.util.UUID;

public abstract class Balance {

    private UUID CustomerId;
    private Double balance;

    public Balance(UUID customerId, Double balance) {
        CustomerId = customerId;
        this.balance = balance;
    }

    public abstract Double addBalance(Double amount);


    public UUID getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(UUID customerId) {
        CustomerId = customerId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
