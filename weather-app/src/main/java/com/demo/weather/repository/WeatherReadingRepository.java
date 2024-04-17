package com.demo.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.weather.entity.WeatherReading;

public interface WeatherReadingRepository extends JpaRepository<WeatherReading, Integer> {
	List<WeatherReading> findByUserId(int userId);
}
