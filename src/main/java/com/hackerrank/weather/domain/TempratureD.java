package com.hackerrank.weather.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TempratureD {
	@Id
	@GeneratedValue
    private Long id;
	private Float temperature;
	
	@ManyToOne
    @JoinColumn(name ="weather_id")
    private WeatherD weather;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public WeatherD getWeather() {
		return weather;
	}
	public void setWeather(WeatherD weather) {
		this.weather = weather;
	}
	

}
