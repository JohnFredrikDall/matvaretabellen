package com.example.matvaretabellen;

import com.example.matvaretabellen.exception.*;
import com.example.matvaretabellen.model.Food;
import com.example.matvaretabellen.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@Validated
@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods() {
        try {
            List<Food> foods = foodService.findAllFoods();
            return new ResponseEntity<>(foods, HttpStatus.OK);
        } catch (FoodListNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Food list not found", e);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("id") Long id) {
        try {
            Food food = foodService.findFoodById(id);
            return new ResponseEntity<>(food, HttpStatus.OK);
        } catch (FoodNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Food object not found", e);
        }
    }

    @PostMapping("/addList")
    public ResponseEntity<List<Food>> addFoodList(
            @Valid
            @RequestBody List<Food> foods) throws Exception {
        try {
            List<Food> foodList = foodService.addFoodList(foods);
            return new ResponseEntity<>(foodList, HttpStatus.CREATED);
        } catch (FoodListNotCreatedException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Food list not created", e
            );
        }
    }
//    @PostMapping("/addFoodCategory")
//    public ResponseEntity<FoodList> addFoodList(
//            @RequestBody FoodList foodlist) throws Exception {
//                try {
//                    FoodList foods = foodService.getFoodListFromJSON(foodlist);
//                    return new ResponseEntity<>(foods, HttpStatus.CREATED);
//                }
//                catch(FoodListNotCreatedException e) {
//                    throw new ResponseStatusException(
//                            HttpStatus.INTERNAL_SERVER_ERROR, "Food list not created", e
//                    );
//                }
//    }


    @PostMapping("/add")
    public ResponseEntity<Food> addFood(
            @Valid
            @RequestBody Food food) {
        try {
            Food newFood = foodService.addFood(food);
            return new ResponseEntity<>(newFood, HttpStatus.CREATED);
        } catch (FoodNotCreatedException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Food object not created ", e
            );
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Food> updateFood(
            @Valid
            @RequestBody Food food) {
        try {
            Food updatedFood = foodService.updateFood(food);
            return new ResponseEntity<>(updatedFood, HttpStatus.OK);
        } catch (FoodNotUpdatedException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Food object not updated", e
            );
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFoodOnId(@PathVariable("id") Long id) {
        try {
            foodService.deleteFood(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (FoodNotDeletedException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Food object not deleted", e
            );
        }
    }
}
