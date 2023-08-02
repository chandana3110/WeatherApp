import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  getweather(city: string) {
    return this.http.get('https://weatherapi-394718.et.r.appspot.com/weather/' + city);
  }
  
}
