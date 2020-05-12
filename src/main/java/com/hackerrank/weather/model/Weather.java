package com.hackerrank.weather.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackerrank.weather.domain.TempratureD;
import com.hackerrank.weather.domain.WeatherD;

public class Weather {
    private Long id;
    private Date dateRecorded;
    private Location location;
    private Float[] temperature;

    public Weather() {
    }
    
    public Weather(WeatherD weatherD) {
    	this.id=weatherD.getId();
    	this.dateRecorded=weatherD.getDateRecorded();
    	this.location=new Location();
    	this.location.setCityName(weatherD.getLocation().getCityName());
    	this.location.setStateName(weatherD.getLocation().getStateName());
    	this.location.setLatitude(weatherD.getLocation().getLatitude());
    	this.location.setLongitude(weatherD.getLocation().getLongitude());
    	Float[] temprature=new Float[weatherD.getTemperature().size()];
    	int i=0;
    	for(TempratureD temp : weatherD.getTemperature()) {
    		temprature[i++]=temp.getTemperature();
    	}
    	this.temperature=temprature;
    }

    public Weather(Long id, Date dateRecorded, Location location, Float[] temperature) {
        this.id = id;
        this.dateRecorded = dateRecorded;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("date")
    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
    
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("temperature")
    public Float[] getTemperature() {
        return temperature;
    }

    public void setTemperature(Float[] temperature) {
        this.temperature = temperature;
    }
}
