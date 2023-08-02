package com.weather.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.main.models.Weather;
import com.weather.main.services.WeatherService;

@RestController
@CrossOrigin
public class WeatherController {

	private final WeatherService weatherService;

	@Autowired
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/")
	String home() {
		return "This is Spring Boot Weather API Backend Application!";
	}

	@RequestMapping("weather/{city}")
	public Weather getWeather(@PathVariable String city) {
		return this.weatherService.getWeather(city);
	}

}
