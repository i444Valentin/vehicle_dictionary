package com.dictionary.vehicle.vehicle_dictionary.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String brand;
    String model;
    String category;
    String number;
    String type;
    String manufactured;
    @Nullable
    boolean trailer;
}
