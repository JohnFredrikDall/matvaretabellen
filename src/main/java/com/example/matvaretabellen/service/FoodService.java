package com.example.matvaretabellen.service;

import com.example.matvaretabellen.exception.FoodNotFoundException;
import com.example.matvaretabellen.model.Food;
import com.example.matvaretabellen.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class FoodService {
    private final FoodRepo foodRepo;

    @Autowired
    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    public Food addFood(Food food){
        food.setFoodCode(UUID.randomUUID().toString());
        return foodRepo.save(food);
    }

    public List<Food> findAllFoods() {
        return foodRepo.findAll();
    }

    public Food findFoodById(Long id) {
        return foodRepo.findFoodById(id).
                orElseThrow(() -> new FoodNotFoundException("Food by id " + id + " was not found"));
    }

    public Food updateFood(Food food) {
        return foodRepo.save(food);
    }

    @Transactional
    public void deleteFood(Long id) {
        foodRepo.deleteFoodById(id);
    }

    public List<Food> addFoodList(List<Food> foods) throws Exception {
        try{
            foods.forEach(x -> x.setFoodCode(UUID.randomUUID().toString()));
            return foodRepo.saveAll(foods);
        }
        catch (Exception e){
            throw new Exception("Posting foodlist failed: ", e);
        }
    }
}
