package com.cydeo;

import com.cydeo.category.Category;

import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final Double price;
    private final Integer stock;
    private final Integer remainingStock;
    private final UUID categoryId;

    public Product(UUID id, String name, Double price, Integer stock, Integer remainingStock, UUID categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.remainingStock = remainingStock;
        this.categoryId = categoryId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getRemainingStock() {
        return remainingStock;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getCategoryName(){
        for (Category category : StaticConstants.CATEGORY_LIST) {
            if (category.getId().equals(getCategoryId())){
                return category.getName();
            }
        }
        throw new RuntimeException("Category not found : " + getName());
    }
}
