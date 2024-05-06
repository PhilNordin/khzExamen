package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.CarEntity;
import com.philip.khzExamen.models.CustomerEntity;
import com.philip.khzExamen.models.OrderEntity;
import com.philip.khzExamen.repositories.CarRepository;
import com.philip.khzExamen.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }


}