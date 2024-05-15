package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.Entities.CarEntity;
import com.philip.khzExamen.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<CarEntity> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("carEntity", new CarEntity());
        return "carCatalogue";
    }

    @GetMapping("/edit-car")
    public String showEditTaskPage(
            @RequestParam("carId")
            Long carId,
            Model model)
    {

        CarEntity car = carRepository.findById(carId).orElse(null);

        if (car == null) {
            // Handle task not found error
            return "error-page";
        }

        model.addAttribute("carId", car.getId());
        model.addAttribute("carBrand", car.getBrand());
        model.addAttribute("carModel", car.getModel());

        return "edit-car";
    }

    @PostMapping("/edit-car")
    public String saveCar(
            @RequestParam("carId") Long carId,
            @RequestParam("title") String title,
            @RequestParam("description") String description)
    {

        CarEntity car = carRepository.findById(carId).orElse(null);
        if (car == null) {
            return "error-page";
        }

        car.setBrand(title);
        car.setDescription(description);
        carRepository.save(car);

        return "redirect:/cars";
    }

}
