package com.hackerrank.weather.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.weather.domain.LocationD;
import com.hackerrank.weather.domain.TempratureD;
import com.hackerrank.weather.domain.WeatherD;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.TempratureRepository;
import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@Autowired
	private TempratureRepository tempratureRepository;
	
	@Transactional
	@Override
	public void add(Weather dto) {
		WeatherD weatherD=new WeatherD();
		weatherD.setId(dto.getId());
		weatherD.setDateRecorded(dto.getDateRecorded());
		List<TempratureD> temps= new ArrayList<>();
		for (Float t : dto.getTemperature()) {
			TempratureD temp=new TempratureD();
			temp.setTemperature(t);
			temps.add(temp);
		}
		weatherD.setTemperature(new HashSet<>(temps));
		
		if(dto.getLocation() != null) {
			LocationD locationD=new LocationD();
			locationD.setCityName(dto.getLocation().getCityName());
			locationD.setLatitude(dto.getLocation().getLatitude());
			locationD.setLongitude(dto.getLocation().getLongitude());
			locationD.setStateName(dto.getLocation().getStateName());
			locationD.setWeatherId(dto.getId());
			weatherD.setLocation(locationD);
		}
		
		weatherD=weatherRepository.save(weatherD);
		
	}
	
	@Transactional
	@Override
	public void update(Weather dto) {
		
		tempratureRepository.deleteByWeatherId(dto.getId());
		
		WeatherD weatherD=new WeatherD();
		weatherD.setId(dto.getId());
		weatherD.setDateRecorded(dto.getDateRecorded());
		List<TempratureD> temps= new ArrayList<>();
		for (Float t : dto.getTemperature()) {
			TempratureD temp=new TempratureD();
			temp.setTemperature(t);
			temps.add(temp);
		}
		weatherD.setTemperature(new HashSet<>(temps));
		
		if(dto.getLocation() != null) {
			LocationD locationD=new LocationD();
			locationD.setCityName(dto.getLocation().getCityName());
			locationD.setLatitude(dto.getLocation().getLatitude());
			locationD.setLongitude(dto.getLocation().getLongitude());
			locationD.setStateName(dto.getLocation().getStateName());
			locationD.setWeatherId(dto.getId());
			weatherD.setLocation(locationD);
		}
		weatherD=weatherRepository.save(weatherD);
		
	}
	
	@Override
	public void deleteAll() {
		weatherRepository.deleteAll();
	}
	
	@Override
	public void deleteByDate(Date startDate,Date endDate) {
		weatherRepository.deleteByDateRecordedBetween(startDate, endDate);
	}
	
	@Override
	public void deleteById(Long id) {
		weatherRepository.delete(id);
	}
	
	@Override
	public Boolean exists(Long id) {
		WeatherD weatherD=weatherRepository.findOne(id);
		return weatherD != null;
	}
	
	@Override
	public Weather findById(Long id) {
		WeatherD weatherD=weatherRepository.findOne(id);
		return new Weather(weatherD);
	}
	
	@Override
	public List<Weather> findByDate(Date startDate,Date endDate) {
		List<WeatherD> weatherDList=weatherRepository.findByDateRecordedBetween(startDate, endDate);
		List<Weather> weatherList=new ArrayList<>();
		for(WeatherD weatherD : weatherDList) {
			weatherList.add(new Weather(weatherD));
		}
		return weatherList;
	}
	
}
