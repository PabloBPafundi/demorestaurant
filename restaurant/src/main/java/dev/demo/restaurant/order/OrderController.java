package dev.demo.restaurant.order;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }

    @GetMapping("")
    List<Order> listOrders(){
        return orderRepository.listOrders();
    }

    @PostMapping("")
    void addOrder(@Valid @RequestBody Order order){
        orderRepository.addOrder(order);
    }


    @PutMapping("/{id}/{status}")
    void changeStatus(@PathVariable Integer id, @PathVariable String status) {
        orderRepository.changeStatus(id, status);

    }




}
