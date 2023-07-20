package com.dictionary.vehicle.vehicle_dictionary.controller;

import com.dictionary.vehicle.vehicle_dictionary.mapper.VehicleToDtoMapper;
import com.dictionary.vehicle.vehicle_dictionary.mapper.VehicleToEntityMapper;
import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.model.dto.VehicleRequest;
import com.dictionary.vehicle.vehicle_dictionary.model.dto.VehicleResponse;
import com.dictionary.vehicle.vehicle_dictionary.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/search")
    public List<VehicleResponse> getVehicleByHisData(@RequestParam(name="brand") String brand,
                                                     @RequestParam(name="model") String model,
                                                     @RequestParam(name="category") String category,
                                                     @RequestParam(name="number") String number,
                                                     @RequestParam(name="year") String year){
        List<Vehicle> vehicles = vehicleService.getVehiclesByBrandOrModelOrCategoryOrNumberOrYear(brand, model, category, number, year);
        List<VehicleResponse> response = new ArrayList<>();
        for (Vehicle vehicle: vehicles){
            response.add(mapper.VehicleToVehicleResponse(vehicle));
        }
        return response;

    }

    @GetMapping
    public List<VehicleResponse> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<VehicleResponse> response = new ArrayList<>();
        for (Vehicle vehicle: vehicles){
            response.add(mapper.VehicleToVehicleResponse(vehicle));
        }
        return response;
    }

    @PostMapping
    public void addVehicle(@RequestBody VehicleRequest request) {
        vehicleService.addVehicle(mapper.VehicleRequestToVehicle(request));
    }
}
