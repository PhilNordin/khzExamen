package com.philip.khzExamen.controllers;

import com.philip.khzExamen.models.Entities.CarEntity;
import com.philip.khzExamen.models.Entities.OrderEntity;
import com.philip.khzExamen.models.Entities.UserEntity;
import com.philip.khzExamen.repositories.OrderRepository;
import com.philip.khzExamen.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;



    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/order-page") // Update the mapping endpoint
    public String showOrdersPage(OrderEntity orderEntity, Model model) { // Update method name and parameter names

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);
        List<OrderEntity> userOrders = currentUser.getOrders(); // Update variable name

        model.addAttribute("userOrders", userOrders); // Update attribute name

        return "order-page"; // Update the view name
    }

    @GetMapping("/create-order")
    public String registerUser(
            @Valid OrderEntity order,   // @Valid annotation to enable validation
            BindingResult result,     // BindingResult parameter immediately following @Valid parameter
            @AuthenticationPrincipal UserEntity currentUser // Principal user entity
    ) {
        // Check for validation errors
        if (result.hasErrors()) {
            return "order"; // Return the same view to display validation errors
        }

        // Save the order with the user association
        order.setUser(currentUser);
        orderRepository.save(order);

        return "redirect:/create-order"; // Redirect to the tasks page after successful task creation
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<OrderEntity> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        model.addAttribute("orderEntity", new OrderEntity());
        return "order-page";
    }
}
