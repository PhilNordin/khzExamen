package com.philip.khzExamen.service;


import com.philip.khzExamen.models.CarsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    // Method to retrieve all cars
    public List<CarsEntity> getAllCars() {
        return carsRepository.findAll();
    }

    // Method to retrieve a single car by ID
    public CarsEntity getCarById(long id) {
        Optional<CarsEntity> optionalCar = carsRepository.findById(id);
        return optionalCar.orElse(null);
    }

    // Method to create a new car
    public CarsEntity createCar(CarsEntity car) {
        return carsRepository.save(car);
    }

    // Method to update an existing car
    public CarsEntity updateCar(long id, CarsEntity updatedCar) {
        Optional<CarsEntity> optionalCar = carsRepository.findById(id);
        if (optionalCar.isPresent()) {
            CarsEntity existingCar = optionalCar.get();
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setDescription(updatedCar.getDescription());
            existingCar.setSeats(updatedCar.getSeats());
            // Set other properties similarly
            return carsRepository.save(existingCar);
        } else {
            return null; // Car with the given ID not found
        }
    }

    // Method to delete an existing car
    public void deleteCar(long id) {
        carsRepository.deleteById(id);
    }
}