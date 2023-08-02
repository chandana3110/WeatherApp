package com.weather.main.services;

import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.main.models.Weather;

@Service
public class WeatherService extends MappingJackson2HttpMessageConverter {

	private static WeatherService ourInstance = new WeatherService();

	private static String apiKey = "3fcc519a88b969c3b67d1d43affd1c35";

	public static WeatherService getInstance() {
		return ourInstance;
	}

	private WeatherService() {
		setPrettyPrint(true);
	}

	public Weather getWeather(String city) {

		String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&mode=json&appid="
				+ apiKey + "&units=metric";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(websiteResponse, String.class);

		JSONObject root = new JSONObject(result);
		JSONObject main = root.getJSONObject("main");
		JSONObject weatherObject = root.getJSONArray("weather").getJSONObject(0);

		Weather weather = new Weather();
		weather.setTemp(main.getDouble("temp"));
		weather.setFeelsLikeTemp(main.getDouble("feels_like"));
		weather.setTempMin(main.getDouble("temp_min"));
		weather.setTempMax(main.getDouble("temp_max"));
		weather.setPressure(main.getInt("pressure"));
		weather.setHumidity(main.getInt("humidity"));
		weather.setMain(weatherObject.getString("main"));
		weather.setDescription(weatherObject.getString("description"));
		weather.setIcon(weatherObject.getString("icon"));
		weather.setCity(root.getString("name"));
		return weather;
	}

}
