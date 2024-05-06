package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.CarEntity;
import com.philip.khzExamen.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarController {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

}
