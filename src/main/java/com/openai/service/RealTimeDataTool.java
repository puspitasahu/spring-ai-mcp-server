package com.openai.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RealTimeDataTool{
    private final RestTemplate restTemplate;

    public RealTimeDataTool( RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Tool(description = "Get current weather for a given city")
    public String getWeatherInfo(@ToolParam(description = "City name like Bangalore,London") String city){
        System.out.println("TOOL Calling : -- Fetching weather information for city: " + city);
        return  restTemplate.getForObject("https://api.weatherapi.com/v1/current.json?q=" + city + "&key=cbadb6cabe224ddd864182546261803", String.class);
    }
    @Tool(description = "Get current time for a given city")
    public String getTimezoneInformation(@ToolParam(description = "City name like Bangalore,London") String city) {
        System.out.println("TOOL Calling : -- Fetching timezone information for city: " + city);
        return restTemplate
                .getForObject("https://api.weatherapi.com/v1/timezone.json?q=" + city + "&key=cbadb6cabe224ddd864182546261803", String.class);
    }



}
