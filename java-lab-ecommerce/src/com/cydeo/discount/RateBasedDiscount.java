package com.cydeo.discount;

import java.util.UUID;

public class RateBasedDiscount extends Discount {

    private Double discountRate;

    public RateBasedDiscount(UUID id, String name, Double thresholdAmount) {
        super(id, name, thresholdAmount);
    }

    @Override
    public Double calculateCartAmountAfterDiscountApplied(Double amount) {
        //TO DO
        return 0.0;
    }

    public Double getDiscountRate() {
        return discountRate;
    }
}
