package example.springboot.jpa.service;

import example.springboot.jpa.custom.OrderSummary;
import example.springboot.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderSummary> findOrdersSummary() {
        return orderRepository.findAllOrdersSummary();
    }

}
