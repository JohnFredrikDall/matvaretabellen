package com.example.matvaretabellen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Food implements Serializable {
    @Id
    private Long id;
    private static final AtomicInteger counter = new AtomicInteger(0);

    @NotEmpty(message = "Food name cannot be empty!")
    private String name;

    private Double calories;
    private Double fat;
    private Double carbohydrates;
    private Double protein;
    private Double percentageEdiblePart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    @JsonBackReference
    private FoodCategory foodCategory;

    public Food() {
        id = (long) counter.incrementAndGet();
    }

    public Food(Long id, String name, Double calories, Double fat, Double carbohydrates, Double protein, Double percentageEdiblePart, FoodCategory foodCategory) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.percentageEdiblePart = percentageEdiblePart;
        this.foodCategory = foodCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getPercentageEdiblePart() {
        return percentageEdiblePart;
    }

    public void setPercentageEdiblePart(Double percentageEdiblePart) {
        this.percentageEdiblePart = percentageEdiblePart;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", protein=" + protein +
                ", percentageEdiblePart=" + percentageEdiblePart +
                ", foodCategory=" + foodCategory +
                '}';
    }
}
