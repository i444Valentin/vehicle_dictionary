package com.dictionary.vehicle.vehicle_dictionary.controller;

import com.dictionary.vehicle.vehicle_dictionary.mapper.VehicleToDtoMapper;
import com.dictionary.vehicle.vehicle_dictionary.mapper.VehicleToEntityMapper;
import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.model.dto.VehicleRequest;
import com.dictionary.vehicle.vehicle_dictionary.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final VehicleToDtoMapper mapper;

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public void addVehicle(@RequestBody VehicleRequest request) {
        vehicleService.addVehicle(mapper.VehicleRequestToVehicle(request));
    }
}
