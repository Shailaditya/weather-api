package com.hackerrank.weather.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.weather.model.ApiResponse;
import com.hackerrank.weather.model.ApiResponse.Status;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;

@RestController
public class WeatherApiRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	@PostMapping(path="/weather",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse> addWeatherReading(@RequestBody Weather dto) {
		if(weatherService.exists(dto.getId()))
			return new ResponseEntity<>(new ApiResponse(Status.ERROR,"Resource aleady exists"),HttpStatus.BAD_REQUEST);
		weatherService.add(dto);
		return new ResponseEntity<>(new ApiResponse(Status.SUCCESS),HttpStatus.CREATED);
    }
	
	@DeleteMapping(path="/weather")
    public ResponseEntity<ApiResponse> deleteWeather() {
		weatherService.deleteAll();
		return new ResponseEntity<>(new ApiResponse(Status.SUCCESS),HttpStatus.OK);
    }
	
	@DeleteMapping(path="/weather/{id}")
    public ResponseEntity<ApiResponse> deleteWeatherById(@PathVariable Long id) {
		if(!weatherService.exists(id))
			return new ResponseEntity<ApiResponse>(new ApiResponse(Status.ERROR,"Resource doesn't exists"),HttpStatus.NOT_FOUND);
		weatherService.deleteById(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(Status.SUCCESS),HttpStatus.OK);	
    }
	
	@PatchMapping(path="/weather/{id}",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse> update(@RequestBody Weather dto,@PathVariable String id) {
		if(!weatherService.exists(dto.getId()))
			return new ResponseEntity<>(new ApiResponse(Status.ERROR,"Resource doesn't exists"),HttpStatus.NOT_FOUND);
		weatherService.update(dto);
		return new ResponseEntity<>(new ApiResponse(Status.SUCCESS),HttpStatus.OK);
    }
	
	@GetMapping(path="/weather/{id}",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
		Weather weather=weatherService.findById(id);
		return new ResponseEntity<>(new ApiResponse(Status.SUCCESS,weather),HttpStatus.OK);
    }
	
	@GetMapping(path="/weather",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse> getById(@RequestParam(value="start_date") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
    		@RequestParam(value="end_date") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		List<Weather> weatherList=weatherService.findByDate(startDate, endDate);
		return new ResponseEntity<>(new ApiResponse(Status.SUCCESS,weatherList),HttpStatus.OK);
    }
	

}
