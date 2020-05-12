package com.hackerrank.weather.service;

import java.util.Date;
import java.util.List;
import com.hackerrank.weather.model.Weather;

public interface WeatherService {
	
	void add(Weather dto);
	
	void update(Weather dto);
	
	void deleteAll();
	
	void deleteByDate(Date startDate,Date endDate);
	
	void deleteById(Long id);
	
	Boolean exists(Long id);
	
	Weather findById(Long id);
	
	List<Weather> findByDate(Date startDate,Date endDate);

}
