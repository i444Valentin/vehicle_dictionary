package com.dictionary.vehicle.vehicle_dictionary.service;

import com.dictionary.vehicle.vehicle_dictionary.entity.VehicleEntity;
import com.dictionary.vehicle.vehicle_dictionary.mapper.VehicleToEntityMapper;
import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleToEntityMapper mapper;


    @Override
    public Vehicle getVehicleById(Long id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Транспорт с таким id отсутствует"));
        return mapper.entityVehicleToVehicle(vehicleEntity);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        Iterable<VehicleEntity> iterable = vehicleRepository.findAll();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (VehicleEntity vehicleEntity : iterable) {
            vehicles.add(mapper.entityVehicleToVehicle(vehicleEntity));
        }

        return vehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = mapper.vehicleToVehicleEntity(vehicle);
        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = mapper.vehicleToVehicleEntity(vehicle);
        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = mapper.vehicleToVehicleEntity(vehicle);
        vehicleRepository.delete(vehicleEntity);
    }
}
