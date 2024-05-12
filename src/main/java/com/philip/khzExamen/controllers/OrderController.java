package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.Entities.OrderEntity;
import com.philip.khzExamen.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;



    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order")
    @ResponseBody
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

}
