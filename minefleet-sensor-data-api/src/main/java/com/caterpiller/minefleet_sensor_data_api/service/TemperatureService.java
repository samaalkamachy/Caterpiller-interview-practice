package com.caterpiller.minefleet_sensor_data_api.service;

import com.caterpiller.minefleet_sensor_data_api.model.TemperatureModel;
import com.caterpiller.minefleet_sensor_data_api.repository.TemperatureRepository;

public class TemperatureService {
    private static final double TEMPERATURE_THRESHOLD = 100.0;
    private final TemperatureRepository repository;

    public TemperatureService(TemperatureRepository repository) {
        this.repository = repository;
    }
    
    public void processTemperature(TemperatureModel temperatureModel) {
        // Validate the incoming data is complete and correct, then save it to the database and check for alerts
        validate(temperatureModel);
        repository.save(temperatureModel);
        checkForAlert(temperatureModel);
    }

    public TemperatureModel getLatestTemperature(String sensorId) {
        return repository.findLatestBySensorId(sensorId);
    }

    private void validate(TemperatureModel temperatureModel) {
        // Basic validation to ensure required fields are present
        if (temperatureModel.getSensorId() == null || temperatureModel.getSensorId().isBlank()) {
            throw new IllegalArgumentException("sensorId is required");
        }
        if (temperatureModel.getTimestamp() == null) {
            throw new IllegalArgumentException("timestamp is required");
        }
    }
    
    private void checkForAlert(TemperatureModel temperatureModel) {
        if (temperatureModel.getTemperature() > TEMPERATURE_THRESHOLD) {
            // In a real application, you would send an alert to a monitoring system or notify relevant personnel
            System.out.println(
                "ALERT: Temperature exceeded threshold for sensor " + temperatureModel.getSensorId()
            );
        }
    }
}
