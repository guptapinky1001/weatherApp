package com.demo.weather.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_readings")
public class WeatherReading {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "TEMPERATURE")
	private double temperature;

	@Column(name = "HUMIDITY")
	private double humidity;

	@Column(name = "WIND_SPEED")
	private double windSpeed;

	@Column(name = "WEATHER_DETAIL")
	private String weatherDetail;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_TIME_STAMP")
	private LocalDateTime createdTimeStamp;

	@Column(name = "UPDATED_BY")
	private String updatedBy;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWeatherDetail() {
		return weatherDetail;
	}

	public void setWeatherDetail(String weatherDetail) {
		this.weatherDetail = weatherDetail;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WeatherReading(int id, User user, double temperature, double humidity, double windSpeed,
			String weatherDetail, String createdBy, LocalDateTime createdTimeStamp, String updatedBy) {
		super();
		this.id = id;
		this.user = user;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.weatherDetail = weatherDetail;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedBy = updatedBy;
	}

	public WeatherReading() {
		super();
	}


}

