package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Example;
import com.demo.model.Response;
import com.demo.service.WeatherService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/demo/weather/v1")
public class WeatherController {
	
	@Autowired
	private WeatherService service;
	
	@ApiOperation(value = "get Weather By City name ", notes = "get Weather")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "get Weather"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/getweatherByCityName", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity<?> getWeather(@RequestParam String param) {
		Response<ResponseEntity<Example>> resp = new Response<>();
		try {
			resp.setCode("SUCCESS");
			service.getWeatherByCity(param);
			return new ResponseEntity<ResponseEntity<Example>>(service.getWeatherByCity(param),HttpStatus.CREATED);
		}catch(Exception ex) {
			ex.printStackTrace();
			Response<String> errorResp = new Response<>();
			errorResp.setCode("FAIL");
			errorResp.setMessage("Error while fetching the record");
			errorResp.setMessage("Error while fetching the record for City:"+param);
			return new ResponseEntity<Response<String>>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
