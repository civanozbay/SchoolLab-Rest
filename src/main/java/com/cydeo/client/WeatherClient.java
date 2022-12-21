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

    @GetMapping("/current?access_key=6fdddbadc0126af7fc0e5013a074a52f&query=London")
    CityDTO getCityInfo(@PathVariable("city") String city);

}
