import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {Food} from 'src/app/food';
import { FoodService } from './food.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  public foods: Food[];

  constructor(private foodService: FoodService){
    this.foods = []
  }

  ngOnInit(): void {
      this.getFoods();
  }

  public getFoods(): void {
    this.foodService.getFoods().subscribe({
      next: (result: Food[]) => {
        this.foods = result;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    });
  }
}
