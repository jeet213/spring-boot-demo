package com.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Example;

@Service
public class WeatherService {

	@Value("${url}")
	private String url;
	
	public ResponseEntity<Example> getWeatherByCity(String cityName) throws Exception {
		RestTemplate template = new RestTemplate();
		return template.getForEntity(url+"?q="+cityName, Example.class);
	}
}
