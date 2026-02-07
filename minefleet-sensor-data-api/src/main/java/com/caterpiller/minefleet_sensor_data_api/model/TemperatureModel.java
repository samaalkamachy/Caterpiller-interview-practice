package com.caterpiller.minefleet_sensor_data_api.model;

import java.time.LocalDateTime;

public class TemperatureModel {

    private String sensorId;
    private LocalDateTime timestamp;
    private double temperature;

    // Default constructor
    public TemperatureModel() {
    }

    // Constructor with all fields
    public TemperatureModel(String sensorId, LocalDateTime timestamp, double temperature) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    // Getters and Setters
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}