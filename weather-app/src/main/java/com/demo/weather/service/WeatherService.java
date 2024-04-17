package com.demo.weather.service;

import java.util.List;

import com.demo.weather.dto.WeatherReadingResponse;
import com.demo.weather.entity.User;

public interface WeatherService {

	User saveCurrentLocation(User user);

	void pullWeatherInformation();

	List<WeatherReadingResponse> getWeatherHistory(int userId);




}
