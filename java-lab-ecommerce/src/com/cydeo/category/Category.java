package com.cydeo.category;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Category {

    private final UUID id;
    private final String name;


    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract LocalDateTime findDeliveryDueDate();

    public String generateCategoryCode() {
        return id.toString().substring(0, 8).concat(" - ").concat(name.substring(0, 2));
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
