package com.hackerrank.weather.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.weather.domain.TempratureD;

@Repository
public interface TempratureRepository extends CrudRepository<TempratureD, Long> {
	
	public void deleteByWeatherId(Long weatherId);
	
}

