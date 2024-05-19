package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.Entities.CustomerEntity;
import com.philip.khzExamen.models.Entities.OrderEntity;
import com.philip.khzExamen.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//    @GetMapping("/customers")
//    @ResponseBody
//    public List<CustomerEntity> getAllCustomers() {
//        return customerRepository.findAll();
//    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<CustomerEntity> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerEntity", new CustomerEntity());
        return "customer-page";
    }


}