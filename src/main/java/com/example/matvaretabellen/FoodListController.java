package com.example.matvaretabellen;

import com.example.matvaretabellen.model.FoodList;
import com.example.matvaretabellen.service.FoodListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/foodList")
public class FoodListController {
    private final FoodListService foodListService;

    public FoodListController(FoodListService foodListService) {
        this.foodListService = foodListService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodList>> getAllFoodLists() {
        try {
            List<FoodList> foodLists = foodListService.findAllFoodLists();
            return new ResponseEntity<>(foodLists, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List of all foodlists not found: " + e);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FoodList> getFoodListById(@PathVariable("id") Long id) {
        try {
            FoodList foodList = foodListService.getFoodListById(id);
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FoodList not found: " + e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<FoodList> addFoodList(
            @Valid
            @RequestBody FoodList foodList) {
        try {
            FoodList newFoodList = foodListService.addFoodList(foodList);
            return new ResponseEntity<>(
                    newFoodList,
                    HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "FoodList not created: " + e);
        }
    }

    @PostMapping("/addList")
    public ResponseEntity<List<FoodList>> addFoodListFromArray(
            @Valid
            @RequestBody List<FoodList> foodLists
    ) {
        List<FoodList> newFoodListArray = foodListService.addFoodLists(foodLists);
        try {
            return new ResponseEntity<>(newFoodListArray, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FoodListArray was not created: " + e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<FoodList> updateFoodList(
            @Valid
            @RequestBody FoodList foodList) {
        try {
            FoodList updatedFoodList = foodListService.updateFoodList(foodList);
            return new ResponseEntity<>(updatedFoodList, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FoodList not updated: " + e);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFoodListById(@PathVariable("id") Long id) {
        try {
            foodListService.deleteFoodListById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "FoodList object not deleted: " + e
            );
        }
    }


}
