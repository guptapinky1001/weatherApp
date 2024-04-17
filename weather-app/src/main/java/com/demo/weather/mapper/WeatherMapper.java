package com.demo.weather.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.weather.dto.WeatherReadingResponse;
import com.demo.weather.entity.WeatherReading;

@Component
public class WeatherMapper {

	public WeatherReadingResponse toResponse(WeatherReading weatherReading) {
		WeatherReadingResponse response = new WeatherReadingResponse();
		response.setId(weatherReading.getId());
		response.setUsername(weatherReading.getUser().getUsername());
		response.setLatitude(weatherReading.getUser().getLatitude());
		response.setLongitude(weatherReading.getUser().getLongitude());
		response.setTemperature(weatherReading.getTemperature());
		response.setHumidity(weatherReading.getHumidity());
		response.setWeatherDetail(weatherReading.getWeatherDetail());
		response.setCreatedTimeStamp(weatherReading.getCreatedTimeStamp());
		return response;
	}

	public List<WeatherReadingResponse> toResponseList(List<WeatherReading> weatherReadings) {
		List<WeatherReadingResponse> responseList = new ArrayList<>();
		for (WeatherReading weatherReading : weatherReadings) {
			responseList.add(toResponse(weatherReading));
		}
		return responseList;
	}
}
