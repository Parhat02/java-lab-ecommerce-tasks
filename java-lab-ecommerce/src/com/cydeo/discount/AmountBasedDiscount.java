package com.cydeo.discount;

import java.util.UUID;

public class AmountBasedDiscount extends Discount{

    private final Double discountAmount;

    public AmountBasedDiscount(UUID id, String name, Double thresholdAmount, Double discountAmount) {
        super(id, name, thresholdAmount);
        this.discountAmount = discountAmount;
    }

    @Override
    public Double calculationCartAmountAfterDiscount(Double amount) {
        return amount - discountAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }
}
