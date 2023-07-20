package com.dictionary.vehicle.vehicle_dictionary.service;

import com.dictionary.vehicle.vehicle_dictionary.entity.VehicleEntity;
import com.dictionary.vehicle.vehicle_dictionary.mapper.VehicleToEntityMapper;
import com.dictionary.vehicle.vehicle_dictionary.model.dao.Vehicle;
import com.dictionary.vehicle.vehicle_dictionary.repository.VehicleRepository;
import com.dictionary.vehicle.vehicle_dictionary.service.consumer.VehicleSearchQueryCriteriaConsumer;
import com.dictionary.vehicle.vehicle_dictionary.service.consumer.SearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleToEntityMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;


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
    public List<Vehicle> getVehiclesByBrandOrModelOrCategoryOrNumberOrYear(String brand,String model, String category, String number, String year) {
        Iterable<VehicleEntity> iterable = vehicleRepository.findVehicleByBrandOrModelOrCategoryOrNumberOrManufactured(brand, model, category, number, year);
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
    public List<Vehicle> searchVehiclesByCriteria(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VehicleEntity> query = builder.createQuery(VehicleEntity.class);
        Root<VehicleEntity> r = query.from(VehicleEntity.class);
        Predicate predicate = builder.conjunction();

        VehicleSearchQueryCriteriaConsumer searchConsumer =
                new VehicleSearchQueryCriteriaConsumer(predicate, builder, r);
        params.forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        List<VehicleEntity> vehicleEntities = entityManager.createQuery(query).getResultList();
        for (VehicleEntity vehicleEntity : vehicleEntities) {
            vehicles.add(mapper.entityVehicleToVehicle(vehicleEntity));
        }
        return vehicles;
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
