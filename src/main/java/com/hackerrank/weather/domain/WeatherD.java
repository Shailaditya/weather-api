package com.hackerrank.weather.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class WeatherD {
	@Id
    private Long id;
    private Date dateRecorded;
    
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="weather_id")
    private LocationD location;
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="weather_id")
	private Set<TempratureD> temperature;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateRecorded() {
		return dateRecorded;
	}
	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}
	public LocationD getLocation() {
		return location;
	}
	public void setLocation(LocationD location) {
		this.location = location;
	}
	public Set<TempratureD> getTemperature() {
		return temperature;
	}
	public void setTemperature(Set<TempratureD> temperature) {
		this.temperature = temperature;
	}
    
}
