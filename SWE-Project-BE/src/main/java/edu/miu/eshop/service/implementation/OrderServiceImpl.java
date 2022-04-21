package edu.miu.eshop.service.implementation;

import edu.miu.eshop.model.Order;
import edu.miu.eshop.repository.OrderRepository;
import edu.miu.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders(Long customerId) {
        return this.orderRepository.findById(customerId).stream().toList();
    }

    @Override
    public Order addOrder(Order order) {
        return this.orderRepository.save(order);
    }
}
