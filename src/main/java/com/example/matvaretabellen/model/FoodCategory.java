package com.example.matvaretabellen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class FoodCategory implements Serializable {
    @Id
    private Long id;

    private static final AtomicInteger counter = new AtomicInteger(0);

    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "foodCategory")
    @JsonManagedReference
    private List<Food> foods = new ArrayList<>();

    public FoodCategory() {
        id = (long) counter.incrementAndGet();
    }

    public FoodCategory(String categoryName) {
        id = (long) counter.incrementAndGet();
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

}
