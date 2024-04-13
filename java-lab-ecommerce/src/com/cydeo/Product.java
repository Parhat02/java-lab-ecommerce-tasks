package com.cydeo;

import com.cydeo.category.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final Double price;
    private final Integer stock;
    private Integer remainingStock;
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
    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() throws Exception {
        for (Category category : StaticConstants.CATEGORY_LIST) {
            if (category.getId().equals(getCategoryId())){
                return category.getName();
            }
        }
        throw new Exception("Category not found : " + getName());
    }

    public LocalDateTime getDeliveryDueDate() throws Exception {
        for (Category category : StaticConstants.CATEGORY_LIST) {
            if (getCategoryId().equals(category.getId())){
                return category.findDeliveryDueDate();
            }
        }
        throw new Exception("Category could not found!");
    }
}
