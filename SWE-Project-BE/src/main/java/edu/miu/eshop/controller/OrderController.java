package edu.miu.eshop.controller;

import edu.miu.eshop.model.Order;
import edu.miu.eshop.service.implementation.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"api", "api/order"})
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value = "/")
    public List<Order> getOrders(Long customerId) {
        return this.orderService.getOrders(customerId);
    }

    @GetMapping(value = "/placeOrder")
    public Order placeOrder(Order order) {
        return this.orderService.addOrder(order);
    }
}
