package com.dictionary.vehicle.vehicle_dictionary.model.dto;

import lombok.Data;

@Data
public class VehicleResponse {
    String brand;
    String model;
    String category;
    String number;
    String type;
    String manufactured;
    String trailer;
}
