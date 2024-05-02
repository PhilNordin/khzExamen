package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.CarsEntity;
import com.philip.khzExamen.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarsService carsService;

    // GET endpoint to retrieve all cars
    @GetMapping
    public List<CarsEntity> getAllCars() {
        return carsService.getAllCars();
    }

    // GET endpoint to retrieve a single car by ID
    @GetMapping("/{id}")
    public CarsEntity getCarById(@PathVariable long id) {
        return carsService.getCarById(id);
    }

    // POST endpoint to create a new car
    @PostMapping
    public CarsEntity createCar(@RequestBody CarsEntity car) {
        return carsService.createCar(car);
    }

    // PUT endpoint to update an existing car
    @PutMapping("/{id}")
    public CarsEntity updateCar(@PathVariable long id, @RequestBody CarsEntity car) {
        return carsService.updateCar(id, car);
    }

    // DELETE endpoint to delete an existing car
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carsService.deleteCar(id);
    }
}