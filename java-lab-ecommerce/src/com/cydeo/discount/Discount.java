package com.cydeo.discount;

import java.util.UUID;

public abstract class Discount {

    private UUID id;
    private String name;
    private Double thresholdAmount;

    public Double calculateCartAmountAfterDiscountApplied(Double amount);

    public UUID getId() {
        return id;
    }

    public abstract String getName() {
        return name;
    }

    public Double getThresholdAmount() {
        return thresholdAmount;
    }

}
