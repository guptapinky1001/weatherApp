package com.demo.weather.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.weather.service.WeatherService;

@Component
public class WeatherDataScheduler {

	@Autowired
	private WeatherService weatherService;

	@Scheduled(cron = "0 0 * * * *") /* Defaulted to run every hour */
	public void fetchAndSaveWeatherData() {
		weatherService.pullWeatherInformation();

	}
}
