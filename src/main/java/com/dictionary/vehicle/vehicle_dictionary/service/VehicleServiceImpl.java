package com.dictionary.vehicle.vehicle_dictionary.service;

import com.dictionary.vehicle.vehicle_dictionary.entity.VehicleEntity;
import com.dictionary.vehicle.vehicle_dictionary.model.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;


    @Override
    public Vehicle getVehicleById(Long id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Транспорт с таким id отсутствует"));
        return new Vehicle(vehicleEntity.getId(),
                vehicleEntity.getBrand(),
                vehicleEntity.getModel(),
                vehicleEntity.getCategory(),
                vehicleEntity.getGov_number(),
                vehicleEntity.getType(),
                vehicleEntity.getManufactured(),
                vehicleEntity.isHas_trailer());
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        Iterable<VehicleEntity> iterable = vehicleRepository.findAll();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (VehicleEntity vehicleEntity : iterable) {
            vehicles.add(new Vehicle(vehicleEntity.getId(),
                    vehicleEntity.getBrand(),
                    vehicleEntity.getModel(),
                    vehicleEntity.getCategory(),
                    vehicleEntity.getGov_number(),
                    vehicleEntity.getType(),
                    vehicleEntity.getManufactured(),
                    vehicleEntity.isHas_trailer()));
        }

        return vehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = new VehicleEntity(null,
                vehicle.brand(),
                vehicle.model(),
                vehicle.category(),
                vehicle.gov_number(),
                vehicle.type(),
                vehicle.manufactured(),
                vehicle.has_trailer());
        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = new VehicleEntity(null,
                vehicle.brand(),
                vehicle.model(),
                vehicle.category(),
                vehicle.gov_number(),
                vehicle.type(),
                vehicle.manufactured(),
                vehicle.has_trailer());
        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = new VehicleEntity(null,
                vehicle.brand(),
                vehicle.model(),
                vehicle.category(),
                vehicle.gov_number(),
                vehicle.type(),
                vehicle.manufactured(),
                vehicle.has_trailer());
        vehicleRepository.delete(vehicleEntity);
    }
}
