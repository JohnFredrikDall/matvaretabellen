package com.example.matvaretabellen.repo;

import com.example.matvaretabellen.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory, Long> {
        //Optional<FoodCategory> findFoodCategoryById(Long id);
}
