package com.arthur.ratelimiter.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @RateLimiter(name = "getWeatherRateLimiter" , fallbackMethod = "fallbackGetWeather")
    public String getWeather(final String city) {
        return String.format("Sunny in %s", city);
    }

    public String fallbackGetWeather(final String city) {
        return "Too many Requests"
    }
}
