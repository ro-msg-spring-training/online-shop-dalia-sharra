package ro.msg.learning.shop.utils.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.model.Order;

@Component
public class OrderMapper {
    public Order dtoToOrder(OrderDto orderDto)
    {
        return Order.builder()
                .createdAt(orderDto.getTimestamp())
                .addressCountry(orderDto.getAddressCountry())
                .addressCity(orderDto.getAddressCity())
                .addressCounty(orderDto.getAddressCounty())
                .addressStreetAddress(orderDto.getAddressStreetAddress())
                .build();
    }
}
