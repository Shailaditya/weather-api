package com.hackerrank.weather.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.weather.domain.LocationD;

@Repository
public interface LocationRepository extends CrudRepository<LocationD, Long> {
	
	public void deleteByWeatherId(Long weatherId);
}

