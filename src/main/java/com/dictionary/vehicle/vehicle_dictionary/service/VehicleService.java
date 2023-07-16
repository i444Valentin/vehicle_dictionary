package com.dictionary.vehicle.vehicle_dictionary.service;

import com.dictionary.vehicle.vehicle_dictionary.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle getVehicleById(Long id);
    List<Vehicle> getAllVehicles();
    void addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
}
