import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from  '@angular/common/http';
import {Food} from 'src/app/food';

@Injectable({
    providedIn: 'root'
})

export class FoodService {
    private apiServerUrl = '';

    constructor(private http: HttpClient) {

    }

    public getFoods(): Observable<Food[]> {
        return this.http.get<Food[]>(`${this.apiServerUrl}/food/all`);
    }
}