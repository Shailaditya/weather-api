package com.hackerrank.weather.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.weather.domain.WeatherD;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherD, Long> {
	public void deleteByDateRecordedBetween(Date startDate,Date endDate);
	public List<WeatherD> findByDateRecordedBetween(Date startDate,Date endDate);
}
