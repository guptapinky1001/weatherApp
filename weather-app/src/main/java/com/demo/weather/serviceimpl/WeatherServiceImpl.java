package com.demo.weather.serviceimpl;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.weather.dto.WeatherReadingResponse;
import com.demo.weather.entity.User;
import com.demo.weather.entity.WeatherReading;
import com.demo.weather.mapper.WeatherMapper;
import com.demo.weather.repository.UserRepository;
import com.demo.weather.repository.WeatherReadingRepository;
import com.demo.weather.service.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	@Autowired
	private WeatherReadingRepository weatherReadingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WeatherMapper weatherMapper;

	@Override
	public User saveCurrentLocation(User user) {
		logger.info("into saveCurrentLocation methodr");
		/*
		 * Logic to save user's current location
		 */ LocalDateTime now = LocalDateTime.now();
		user.setCreatedTimeStamp(now);
		user.setUpdatedTimeStamp(now);
		logger.info("End of saveCurrentLocation method");
		return userRepository.save(user);
	}

	
	/*
	 * Logic to call OpenWeatherMap API and save weather readings in weather reading
	 * table
	 */
		@Override
		public void pullWeatherInformation() {
			logger.info("into pullWeatherInformation methodr");
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			/* Making API call to OpenWeatherMap */
			String apiKey = "b41815adb23fcc3f41cbe52017ea16d3"; // Replace with your actual API key
			String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid={apiKey}";

			
			/* Fetching all users of user table */
			List<User> users = userRepository.findAll();

			/* iterating over each user to pull their weather readings */
			for (User user : users) {
				
				Map<String, String> uriVariables = new HashMap<>();
				uriVariables.put("latitude", String.valueOf(user.getLatitude()));
				uriVariables.put("longitude", String.valueOf(user.getLongitude()));
				uriVariables.put("apiKey", apiKey);

				ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET,
						new HttpEntity<>(headers), String.class, uriVariables);

				/* Checking if the above the call was successful */
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					
					/*
					 * Parsing the weather data from the response and saving it to the
					 * weatherreadings table
					 */
					String responseBody = responseEntity.getBody();
					ObjectMapper objectMapper = new ObjectMapper();
					try {
						JsonNode rootNode = objectMapper.readTree(responseBody);
						Double temperature = rootNode.path("main").path("temp").asDouble();
						Double humidity = rootNode.path("main").path("humidity").asDouble();
						String weatherDetail = rootNode.path("weather").get(0).path("description").asText();

						/* Creating a new WeatherReading entity and saving it to the database */
						WeatherReading weatherReading = new WeatherReading();
						weatherReading.setUser(user);
						weatherReading.setTemperature(temperature);
						weatherReading.setHumidity(humidity);
						weatherReading.setWeatherDetail(weatherDetail);
						weatherReading.setCreatedBy("SYSADMIN");
						weatherReading.setCreatedTimeStamp(LocalDateTime.now());
						weatherReading.setUpdatedBy("SYSADMIN");

						// Save the weather reading
						weatherReadingRepository.save(weatherReading);
					} catch (IOException e) {
						logger.error("Error occurred during JSON parse", e);
					}
				} else {
					logger.info("Failed to retrieve weather information from OpenWeatherMap API.");
				}
			}

			logger.info("end of pullWeatherInformation methodr");
		}


	@Override
	public List<WeatherReadingResponse> getWeatherHistory(int userId) {
		logger.info("into getWeatherHistory methodr");
		List<WeatherReading> weatherReadings = weatherReadingRepository.findByUserId(userId);
		return weatherReadings.stream().map(weatherMapper::toResponse).collect(Collectors.toList());
	}


}
