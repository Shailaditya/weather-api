package com.hackerrank.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    private String cityName;
    private String stateName;
    private Float latitude;
    private Float longitude;

    public Location() {
    }

    public Location(String cityName, String stateName, Float latitude, Float longitude) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    @JsonProperty("city")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    @JsonProperty("state")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("lat")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("lon")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
