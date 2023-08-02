import { DOCUMENT } from '@angular/common';
import { WeatherService } from './../weather.service';
import { Component, ElementRef, Inject, OnInit, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  weatherData: any;
  temperature: number = 0;
  feelsLikeTemp: number = 0;
  minTemp: number = 0;
  maxTemp: number = 0;
  humidity: number = 0;
  pressure: number = 0;
  summary: string = '';
  iconURL: string = '';
  city: string = 'Bangalore';

  constructor(@Inject(DOCUMENT) private document: Document, 
                      private renderer: Renderer2, 
                      private weatherService: WeatherService) { }

  ngOnInit(): void {
    this.getWeather();
  }

  findWeather(city: string) {
    this.city = city;
    this.getWeather();
  }

  getWeather() {

    this.weatherService.getweather(this.city).subscribe({

      next: (res) => {
        console.log(res);
        this.weatherData = res;
        this.temperature = this.weatherData.temp;
        this.feelsLikeTemp = this.weatherData.feels_like;
        this.minTemp = this.weatherData.temp_min;
        this.maxTemp = this.weatherData.temp_max;
        this.humidity = this.weatherData.humidity;
        this.pressure = this.weatherData.pressure;
        this.summary = this.weatherData.main;
        this.iconURL = 'https://openweathermap.org/img/wn/' + this.weatherData.icon + '@2x.png';
        console.log(this.weatherData);
      },

      error: (error) => console.log(error.message),

      complete: () => console.info('API call completed')
    })
    this.setBackgroundImage(this.weatherData.icon);
  }

  setBackgroundImage(code: string) {
    var image = '';
    switch(code) {
			case "01d":
				image = "clearDay_bg";			
				break;
			case "01n":
				image = "clearNight_bg";
				break;
			case "02d":
				image = "fewCloudsDay_bg";
				break;
			case "02n":
				image = "fewCloudsNight_bg";
				break;
			case "03d":
			case "04d":
				image = "cloudyDay_bg";
				break;
			case "03n":
			case "04n":
				image = "cloudyNight_bg";
				break;
			case "09d":
			case "10d":
				image = "rainyDay_bg";
				break;
			case "09n":
			case "10n":
				image = "rainyNight_bg";
				break;
			case "11d":
			case "11n":
				image = "thunderstorm_bg";
				break;
			case "13d":
				image = "snowDay_bg";
				break;
			case "13n":
				image = "snowNight_bg";
				break;
			case "50d":
			case "50n":
				image = "mist_bg";
				break;			
			default:
				image = "default_bg";
				break;	
		}
    
    let el = this.document.body;
    let classes = el.getAttribute('class').split(' '); // get all classes
    classes.forEach((cl) => {
      this.renderer.removeClass(el, cl);
    });
    this.renderer.addClass(this.document.body, image);
  }

}
