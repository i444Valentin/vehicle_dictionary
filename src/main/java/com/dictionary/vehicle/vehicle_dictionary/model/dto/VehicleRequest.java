package com.dictionary.vehicle.vehicle_dictionary.model.dto;

import lombok.Data;

@Data
public class VehicleRequest {
    String brand;
    String model;
    String category;
    String number;
    String type;
    String manufactured;
    boolean trailer;
}
