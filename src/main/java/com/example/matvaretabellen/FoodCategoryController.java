package com.example.matvaretabellen;

import com.example.matvaretabellen.model.FoodCategory;
import com.example.matvaretabellen.service.FoodCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/foodCategory")
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;

    public FoodCategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodCategory>> getAllFoodCategories() {
        try {
            List<FoodCategory> foodCategories = foodCategoryService.findAllFoodCategories();
            return new ResponseEntity<>(foodCategories, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List of all foodlists not found: " + e);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FoodCategory> getFoodCategoryById(@PathVariable("id") Long id) {
        try {
            FoodCategory foodCategory = foodCategoryService.getFoodCategoryById(id);
            return new ResponseEntity<>(foodCategory, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FoodList not found: " + e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<FoodCategory> addFoodCategory(
            @Valid
            @RequestBody FoodCategory foodCategory) {
        try {
            FoodCategory newFoodCategory = foodCategoryService.addFoodCategory(foodCategory);
            return new ResponseEntity<>(
                    newFoodCategory,
                    HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "FoodList not created: " + e);
        }
    }

    @PostMapping("/addList")
    public ResponseEntity<List<FoodCategory>> addFoodCategoryFromArray(
            @Valid
            @RequestBody List<FoodCategory> foodCategories
    ) {
        List<FoodCategory> newFoodCategoryArray = foodCategoryService.addFoodCategories(foodCategories);
        try {
            return new ResponseEntity<>(newFoodCategoryArray, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FoodListArray was not created: " + e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<FoodCategory> updateFoodCategory(
            @Valid
            @RequestBody FoodCategory foodCategory) {
        try {
            FoodCategory updatedFoodCategory = foodCategoryService.updateFoodCategory(foodCategory);
            return new ResponseEntity<>(updatedFoodCategory, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FoodList not updated: " + e);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFoodCategoryById(@PathVariable("id") Long id) {
        try {
            foodCategoryService.deleteFoodCategoryById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "FoodList object not deleted: " + e
            );
        }
    }


}
