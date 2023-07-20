package com.dictionary.vehicle.vehicle_dictionary.mapper;

import com.dictionary.vehicle.vehicle_dictionary.mapper.helper.BooleanYNMapper;
import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.model.dto.VehicleRequest;
import com.dictionary.vehicle.vehicle_dictionary.model.dto.VehicleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BooleanYNMapper.class)
public interface VehicleToDtoMapper {
    Vehicle VehicleRequestToVehicle(VehicleRequest vehicleRequest);
    VehicleResponse VehicleToVehicleResponse(Vehicle vehicle);
    @Mapping(target = "id", ignore = true)
    Vehicle VehicleResponseToVehicle(VehicleResponse vehicleResponse);

}
