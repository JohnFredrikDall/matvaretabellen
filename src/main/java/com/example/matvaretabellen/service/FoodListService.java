package com.example.matvaretabellen.service;

import com.example.matvaretabellen.model.Food;
import com.example.matvaretabellen.model.FoodList;
import com.example.matvaretabellen.repo.FoodListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodListService {
    private final FoodListRepo foodListRepo;

    @Autowired
    public FoodListService(FoodListRepo foodListRepo) {
        this.foodListRepo = foodListRepo;
    }

    public List<FoodList> addFoodLists(List<FoodList> foodLists) {
        return foodListRepo.saveAll(foodLists);

    }

    public FoodList addFoodList(FoodList foodList) {
        return foodListRepo.save(foodList);
    }

    public List<FoodList> findAllFoodLists() {
        return foodListRepo.findAll();
    }

    public FoodList getFoodListById(Long id) {
        return foodListRepo.getById(id);
    }

    public FoodList updateFoodList(FoodList foodList) {
        return foodListRepo.save(foodList);
    }

    @Transactional
    public void deleteFoodListById(Long id) {
        foodListRepo.deleteById(id);
    }


}
