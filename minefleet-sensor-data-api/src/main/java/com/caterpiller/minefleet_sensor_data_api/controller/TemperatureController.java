package com.caterpiller.minefleet_sensor_data_api.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.caterpiller.minefleet_sensor_data_api.model.TemperatureModel;
import com.caterpiller.minefleet_sensor_data_api.service.TemperatureService;

@RestController
@RequestMapping("/sensors")
public class TemperatureController {
    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping
    public ResponseEntity<?> submitTemperature(@RequestBody TemperatureModel temperatureModel) {
        try {
            temperatureService.processTemperature(temperatureModel);
            return ResponseEntity.status(201).body(Map.of("message", "Temperature data submitted successfully"));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}