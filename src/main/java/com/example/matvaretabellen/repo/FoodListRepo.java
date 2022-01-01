package com.example.matvaretabellen.repo;

import com.example.matvaretabellen.model.Food;
import com.example.matvaretabellen.model.FoodList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodListRepo extends JpaRepository<FoodList, Long> {
    Optional<FoodList> findFoodListByCategoryId(Long id);
}
