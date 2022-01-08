package com.example.matvaretabellen.service;

import com.example.matvaretabellen.model.Food;
import com.example.matvaretabellen.model.FoodCategory;
import com.example.matvaretabellen.repo.FoodCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodCategoryService {
    private final FoodCategoryRepo foodCategoryRepo;

    @Autowired
    public FoodCategoryService(FoodCategoryRepo foodCategoryRepo) {
        this.foodCategoryRepo = foodCategoryRepo;
    }

    public List<FoodCategory> addFoodCategories(List<FoodCategory> foodCategories) {
        foodCategories.forEach(foodCategory -> foodCategory.getFoods().forEach(x -> x.setFoodCategory(foodCategory)));
        return foodCategoryRepo.saveAll(foodCategories);

    }

    public FoodCategory addFoodCategory(FoodCategory foodCategory) {
        FoodCategory savedFoodCategory = foodCategoryRepo.save(foodCategory);
        savedFoodCategory.getFoods().forEach(x -> x.setFoodCategory(savedFoodCategory));

        return foodCategoryRepo.save(savedFoodCategory);
    }

    public List<FoodCategory> findAllFoodCategories() {
        return foodCategoryRepo.findAll();
    }

    public FoodCategory getFoodCategoryById(Long id) {
        return foodCategoryRepo.getById(id);
    }

    public FoodCategory updateFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepo.save(foodCategory);
    }

    @Transactional
    public void deleteFoodCategoryById(Long id) {
        foodCategoryRepo.deleteById(id);
    }


}
