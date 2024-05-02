package com.philip.khzExamen.controllers;

import com.philip.khzExamen.repositories.CarRepository;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


}
