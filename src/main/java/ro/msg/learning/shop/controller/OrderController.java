package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.service.IOrderService;
import ro.msg.learning.shop.utils.mappers.OrderMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final IOrderService orderService;

    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.dtoToOrder(orderDto);
        this.orderService.createOrder(order, orderDto.getProducts());
        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully!");
    }
}
