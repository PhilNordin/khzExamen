package com.philip.khzExamen.service;

import com.philip.khzExamen.models.Entities.CarEntity;
import com.philip.khzExamen.repositories.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarSortingService {

    private final CarRepository carRepository;

    public CarSortingService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarEntity> sortByCapacity(CarEntity capacity) {
        return carRepository.findByCapacity(capacity);
    }

    public List<CarEntity> sortByType(String type) {
        return carRepository.findByType(type);
    }


}