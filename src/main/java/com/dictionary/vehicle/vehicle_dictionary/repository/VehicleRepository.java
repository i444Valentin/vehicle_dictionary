package com.dictionary.vehicle.vehicle_dictionary.repository;

import com.dictionary.vehicle.vehicle_dictionary.entity.VehicleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {
    List<VehicleEntity> findVehicleByBrandOrModelOrCategoryOrNumberOrManufactured(String brand, String model,
                                                                                      String category, String govNumber,
                                                                                      String manufactured);
}
