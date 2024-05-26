package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.Entities.CarEntity;
import com.philip.khzExamen.models.Entities.OrderEntity; // Assuming you have an OrderEntity class
import com.philip.khzExamen.repositories.CarRepository;
import com.philip.khzExamen.repositories.OrderRepository; // Assuming you have an OrderRepository
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
    private final OrderRepository orderRepository;

    @Autowired
    public CarController(CarRepository carRepository, CarSortingService carSortingService, OrderRepository orderRepository) {
        this.carRepository = carRepository;
        this.carSortingService = carSortingService;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/submit-rental")
    public String checkAvailability(@RequestParam("startDate") String startDate,
                                    @RequestParam("endDate") String endDate,
                                    Model model) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

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

        // Save order to database
        OrderEntity order = new OrderEntity();
        order.setCar(car); // Assuming OrderEntity has a reference to CarEntity
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        orderRepository.save(order);

        model.addAttribute("car", car);
        model.addAttribute("customerName", customerName);
        model.addAttribute("customerEmail", customerEmail);
        return "order-success";
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<CarEntity> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("carEntity", new CarEntity());
        return "carCatalogue";
    }

    @PostMapping("/save-edit-car")
    public String saveCar(@RequestParam("carId") Long carId,
                          @RequestParam("carBrand") String carBrand,
                          @RequestParam("carModel") String carModel) {
        CarEntity car = carRepository.findById(carId).orElse(null);
        if (car == null) {
            return "error-page";
        }

        car.setBrand(carBrand);
        car.setModel(carModel);
        carRepository.save(car);

        return "redirect:/cars";
    }

    @GetMapping("/edit-car")
    public String showEditTaskPage(@RequestParam("carId") Long carId, Model model) {
        CarEntity car = carRepository.findById(carId).orElse(null);

        if (car == null) {
            return "error-page";
        }

        model.addAttribute("carId", car.getId());
        model.addAttribute("carBrand", car.getBrand());
        model.addAttribute("carModel", car.getModel());

        return "edit-car";
    }
}
