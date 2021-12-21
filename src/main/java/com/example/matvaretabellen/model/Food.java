package com.example.matvaretabellen.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Food implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String sortingCode;

    @NotEmpty(message = "Food name cannot be empty!")
    @Size(min=1, max=50)
    private String name;

    private Double calories;
    private Double fat;
    private Double carbohydrates;
    private Double protein;
    private Double percentageEdiblePart;
    @Column(nullable = false, updatable = false)
    private String foodCode;

    public Food() {
    }

    public Food(Long id, String sortingCode, String name, Double calories, Double fat, Double carbohydrates, Double protein, Double percentageEdiblePart, String foodCode) {
        this.id = id;
        this.sortingCode = sortingCode;
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.percentageEdiblePart = percentageEdiblePart;
        this.foodCode = foodCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSortingCode() {
        return sortingCode;
    }

    public void setSortingCode(String sortingCode) {
        this.sortingCode = sortingCode;
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

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", sortingCode='" + sortingCode + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", protein=" + protein +
                ", percentageEdiblePart=" + percentageEdiblePart +
                ", foodCode='" + foodCode + '\'' +
                '}';
    }
}
