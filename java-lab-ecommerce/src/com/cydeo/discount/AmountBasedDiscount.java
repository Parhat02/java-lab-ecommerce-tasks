package com.cydeo.discount;

import java.util.UUID;

public class AmountBasedDiscount extends Discount{

    private Double discountAmount;

    public AmountBasedDiscount(UUID id, String name, Double thresholdAmount, Double discountAmount) {
        super(id, name, thresholdAmount);
        this.discountAmount = discountAmount;
    }

    @Override
    public Double calculateCartAmountAfterDiscountApplied(Double amount) {

        //TO DO
        return 0.0;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }
}
