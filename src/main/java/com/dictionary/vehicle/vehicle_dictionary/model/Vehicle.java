package com.dictionary.vehicle.vehicle_dictionary.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public record Vehicle(Long id, String brand, String model, String category,
                      String gov_number, String type, String manufactured,
                      boolean has_trailer) {
}
