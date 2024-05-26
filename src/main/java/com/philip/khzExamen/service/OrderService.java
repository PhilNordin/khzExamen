package com.philip.khzExamen.service;

import com.philip.khzExamen.models.Entities.CustomerEntity;
import com.philip.khzExamen.models.Entities.OrderEntity;
import com.philip.khzExamen.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(String customerName, String customerEmail) {
        // Here, you would create an OrderEntity object and save it to the database using orderRepository
        // Construct the OrderEntity object with the provided data
        OrderEntity order = new OrderEntity();
        CustomerEntity customer = new CustomerEntity();
        // Set properties of the order object


        order.setId(order.getId());
        // Save the order to the database
        orderRepository.save(order);
    }

    @PostMapping("/save-order")
    public String saveOrder(
            @RequestParam("customerName") String customerName,
            @RequestParam("customerEmail") String customerEmail)
    {

        // Debug
        System.out.println("Received customerName: " + customerName);

        OrderEntity order = new OrderEntity();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        orderRepository.save(order);

        return "redirect:/orders";
    }
}
