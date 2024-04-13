package com.cydeo.discount;

import java.util.UUID;

public class RateBasedDiscount extends Discount{

    private final Double rateAmount;

    public RateBasedDiscount(UUID id, String name, Double thresholdAmount, Double rateAmount) {
        super(id, name, thresholdAmount);
        this.rateAmount = rateAmount;
    }

    @Override
    public Double calculationCartAmountAfterDiscount(Double amount) {
        return amount - (amount * rateAmount/100);
    }

    public Double getRateAmount() {
        return rateAmount;
    }
}
