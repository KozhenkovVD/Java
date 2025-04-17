package app.controller;

import app.model.Customer;
import app.model.Order;
import app.repository.CustomerRepository;
import app.repository.OrderRepository;
import app.repository.impl.CustomerRepositoryImpl;
import app.repository.impl.OrderRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        @GetMapping("/orders")
        public List<Order> getAll() {
            return orderRepository.getAll();
        }
}

