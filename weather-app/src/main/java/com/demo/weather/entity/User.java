package com.demo.weather.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "LATITUDE", nullable = false)
	private double latitude;

	@Column(name = "LONGITUDE", nullable = false)
	private double longitude;

	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "CREATED_TIME_STAMP")
	private LocalDateTime createdTimeStamp;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_TIME_STAMP")
	private LocalDateTime updatedTimeStamp;

	@OneToMany(mappedBy = "user")
	private List<WeatherReading> weatherReadings;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public LocalDateTime getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(LocalDateTime updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public List<WeatherReading> getWeatherReadings() {
		return weatherReadings;
	}

	public void setWeatherReadings(List<WeatherReading> weatherReadings) {
		this.weatherReadings = weatherReadings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User(int id, String username, double latitude, double longitude, String frequency, String createdBy,
			LocalDateTime createdTimeStamp, String updatedBy, LocalDateTime updatedTimeStamp,
			List<WeatherReading> weatherReadings) {
		super();
		this.id = id;
		this.username = username;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedBy = updatedBy;
		this.updatedTimeStamp = updatedTimeStamp;
		this.weatherReadings = weatherReadings;
	}



	public User() {
		super();
	}


}
