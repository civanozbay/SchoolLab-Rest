package com.cydeo.client;

import com.cydeo.dto.CityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com",name = "WEATHER-CLIENT")
public interface WeatherClient {


    @GetMapping("/current")
    CityDTO getCurrentWeather(@RequestParam(value = "access_key") String accessKey,
                             @RequestParam(value = "query") String city);



}
