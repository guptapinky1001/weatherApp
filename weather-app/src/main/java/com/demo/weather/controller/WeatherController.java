package com.demo.weather.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.weather.dto.WeatherReadingResponse;
import com.demo.weather.entity.User;
import com.demo.weather.scheduler.WeatherDataScheduler;
import com.demo.weather.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private WeatherDataScheduler weatherDataScheduler;

	@PostMapping("/save-location")
	public ResponseEntity<User> saveLocation(@RequestBody User user) {
		logger.info("into saveLocation method of controller");
		User createdUser = weatherService.saveCurrentLocation(user);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

	}


	@GetMapping("/history/{userId}")
	public List<WeatherReadingResponse> getWeatherHistory(@PathVariable int userId) {
		logger.info("into getWeatherHistory method of controller");
		return weatherService.getWeatherHistory(userId);
	}

	/*
	 * The below endpoint is to run the batch job for fetching details from Open
	 * Weather Map API. It needs to be triggered externally.
	 */
	@GetMapping("/trigger-scheduler")
	public String triggerScheduler() {
		logger.info("into triggerScheduler method of controller");
		weatherDataScheduler.fetchAndSaveWeatherData();
		return "Scheduler triggered successfully.";
	}
}
