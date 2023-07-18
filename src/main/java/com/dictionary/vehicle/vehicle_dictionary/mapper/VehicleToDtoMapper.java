package com.dictionary.vehicle.vehicle_dictionary.mapper;

import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.model.dto.VehicleRequest;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface VehicleToDtoMapper {
    Vehicle VehicleRequestToVehicle(VehicleRequest vehicleRequest);
}
