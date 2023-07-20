package com.dictionary.vehicle.vehicle_dictionary.service;

import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle getVehicleById(Long id);
    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehiclesByBrandOrModelOrCategoryOrNumberOrYear(String brand,String model, String category, String number, String year);
    void addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
}
