package com.dictionary.vehicle.vehicle_dictionary.mapper;

import com.dictionary.vehicle.vehicle_dictionary.entity.VehicleEntity;
import com.dictionary.vehicle.vehicle_dictionary.model.Vehicle;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface VehicleToEntityMapper {
    VehicleEntity vehicleToVehicleEntity(Vehicle vehicle);
    Vehicle entityVehicleToVehicle(VehicleEntity vehicleEntity);
}
