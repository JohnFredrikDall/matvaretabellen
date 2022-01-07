package com.example.matvaretabellen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "foodCategory")
    private List<Food> foods = new ArrayList<>();

    public FoodCategory() {
    }

    public FoodCategory(String categoryName) {
        this.categoryName = categoryName;
    }


    public Long getcId() {
        return id;
    }

    public void setcId(Long cId) {
        this.id = cId;
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


    @Override
    public String toString() {
        return "FoodCategory{" +
                "cId=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", foods=" + foods +
                '}';
    }
}
