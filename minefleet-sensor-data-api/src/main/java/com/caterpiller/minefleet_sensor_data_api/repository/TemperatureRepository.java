package com.caterpiller.minefleet_sensor_data_api.repository;

import com.caterpiller.minefleet_sensor_data_api.model.TemperatureModel;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TemperatureRepository {
    // Key: sensorId, Value: latest TemperatureModel
    private final Map<String, TemperatureModel> storage = new ConcurrentHashMap<>();

    // Save or update the latest temperature reading for a sensor
    public void save(TemperatureModel temperatureModel) {
        storage.put(temperatureModel.getSensorId(), temperatureModel);
    }

    // Retrieve the latest temperature reading for a given sensorId
    public TemperatureModel findLatestBySensorId(String sensorId) {
        return storage.get(sensorId);
    }
}