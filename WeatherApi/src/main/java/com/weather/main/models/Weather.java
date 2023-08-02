package com.weather.main.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "temp", "feels_like", "temp_min", "temp_max", "pressure", "humidity", "main", "description", "icon", "city" })
public class Weather {

	@JsonProperty("temp")
	private Double temp;
	
	@JsonProperty("feels_like")
	private Double feelsLike;

	@JsonProperty("temp_min")
	private Double tempMin;

	@JsonProperty("temp_max")
	private Double tempMax;
	
	@JsonProperty("pressure")
	private Integer pressure;

	@JsonProperty("humidity")
	private Integer humidity;

	@JsonProperty("main")
	private String main;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("icon")
	private String icon;
	
	@JsonProperty("city")
	private String city;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("temp")
	public Double getTemp() {
		return temp;
	}

	@JsonProperty("temp")
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	
	@JsonProperty("feels_like")
	public Double getFeelsLikeTemp() {
		return tempMin;
	}

	@JsonProperty("feels_like")
	public void setFeelsLikeTemp(Double feelsLike) {
		this.feelsLike = feelsLike;
	}

	@JsonProperty("temp_min")
	public Double getTempMin() {
		return tempMin;
	}

	@JsonProperty("temp_min")
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("temp_max")
	public Double getTempMax() {
		return tempMax;
	}

	@JsonProperty("temp_max")
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
	
	@JsonProperty("pressure")
	public Integer getPressure() {
		return pressure;
	}

	@JsonProperty("pressure")
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	@JsonProperty("humidity")
	public Integer getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("main")
	public String getMain() {
		return main;
	}

	@JsonProperty("main")
	public void setMain(String main) {
		this.main = main;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}

	@JsonProperty("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}