package com.dictionary.vehicle.vehicle_dictionary.model.dao;

import lombok.Value;

@Value
public class Vehicle {
    Long id;
    String brand;
    String model;
    String category;
    String number;
    String type;
    String manufactured;
    boolean trailer;
}
