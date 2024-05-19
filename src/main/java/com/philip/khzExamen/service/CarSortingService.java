package com.philip.khzExamen.service;

import com.philip.khzExamen.models.Entities.CarEntity;
import com.philip.khzExamen.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarSortingService {

    @Autowired
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

//    public List<CarEntity> checkAvailability(LocalDate startDate, LocalDate endDate, int location) {
//        return carRepository.findAvailableCars(startDate, endDate, location);
//    }

}