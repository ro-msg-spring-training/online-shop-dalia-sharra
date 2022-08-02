package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.service.IOrderService;
import ro.msg.learning.shop.utils.Mapper;


@RestController
public class OrderController {
    @Autowired
    IOrderService orderService;

    @Autowired
    private Mapper mapper;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
        Order order = mapper.dtoToOrder(orderDto);
        try {
            this.orderService.createOrder(order, orderDto.getProducts());
            return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully!");

        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
