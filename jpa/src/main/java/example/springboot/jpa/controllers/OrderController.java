package example.springboot.jpa.controllers;

import example.springboot.jpa.custom.OrderSummary;
import example.springboot.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public List<OrderSummary> greeting() {
        return orderService.findOrdersSummary();
    }

}
