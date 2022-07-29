package com.cydeo.balance;

import java.util.UUID;

public class CustomerBalance {

    public CustomerBalance(Double balance, UUID customerId) {
    }

    @Override
    public Double addBalance(Double additionalAmount) {
        setBalance(getBalance() + additionalAmount);
        return getBalance();
    }

}
