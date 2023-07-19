package com.dictionary.vehicle.vehicle_dictionary.model.dao;

public record Vehicle(Long id, String brand, String model, String category,
                      String number, String type, String manufactured, boolean trailer) {
}
