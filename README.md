# Mine Fleet Sensor Data API

## Overview
Spring Boot REST API for ingesting and retrieving temperature sensor data
from mining equipment.

## Endpoints
POST /sensors  
GET /sensors/{id}/latest

## Run Application
mvn spring-boot:run

## Run Tests
mvn test

## Architecture
Controller → Service → Repository → Model  
In-memory storage using ConcurrentHashMap
