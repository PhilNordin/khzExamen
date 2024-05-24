package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.Entities.CarEntity;
import com.philip.khzExamen.repositories.CarRepository;
import com.philip.khzExamen.service.CarSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CarController {
    private final CarRepository carRepository;
    private final CarSortingService carSortingService;

    @Autowired
    public CarController(CarRepository carRepository, CarSortingService carSortingService) {
        this.carRepository = carRepository;
        this.carSortingService = carSortingService;
    }

    @PostMapping("/submit-rental")
    public String checkAvailability(@RequestParam("startDate") String startDate,
                                    @RequestParam("endDate") String endDate,
                                    // @RequestParam("pickup_city") String pickupCity,  // Uncomment for use of location choice
                                    // @RequestParam("return_city") String returnCity,  // Uncomment for use of location choice
                                    Model model) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        // int location = mapCityToLocation(pickupCity); // Implement this method to map city names to location IDs

        // List<CarEntity> availableCars = carSortingService.checkAvailability(start, end, location);  // Uncomment for use of location choice
        List<CarEntity> availableCars = carSortingService.checkAvailability(start, end);

        if (availableCars.isEmpty()) {
            model.addAttribute("noCarsAvailable", true);
            return "index";
        }

        model.addAttribute("availableCars", availableCars);

        return "available-cars";
    }


    @GetMapping("/order-form")
    public String showOrderForm(@RequestParam("carId") Long carId, Model model) {
        CarEntity car = carRepository.findById(carId).orElse(null);
        if (car == null) {
            return "error-page";
        }
        model.addAttribute("car", car);
        return "order-form";
    }

    @PostMapping("/submit-order")
    public String submitOrder(@RequestParam("carId") Long carId,
                              @RequestParam("customerName") String customerName,
                              @RequestParam("customerEmail") String customerEmail,
                              Model model) {
        CarEntity car = carRepository.findById(carId).orElse(null);
        if (car == null) {
            return "error-page"; // Handle car not found
        }

        //databas

        model.addAttribute("car", car);
        model.addAttribute("customerName", customerName);
        return "order-success";
    }


    private int mapCityToLocation(String city) {
        switch (city.toLowerCase()) {
            case "stockholm":
                return 1;
            case "malmo":
                return 2;
            case "goteborg":
                return 3;
            default:
                throw new IllegalArgumentException("Unknown city: " + city);
        }
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
