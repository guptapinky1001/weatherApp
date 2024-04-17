package com.demo.weather.dto;

import java.time.LocalDateTime;

public class WeatherReadingResponse {
	private int id;
	private String username;
	private double latitude;
	private double longitude;
	private double temperature;

	private double windSpeed;
	private double humidity;
	private String weatherDetail;
	private LocalDateTime createdTimeStamp;
	private LocalDateTime updatedTimeStamp;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getWeatherDetail() {
		return weatherDetail;
	}

	public void setWeatherDetail(String weatherDetail) {
		this.weatherDetail = weatherDetail;
	}

	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public LocalDateTime getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(LocalDateTime updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
