package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.repository.IOrderDetailRepository;

@Service
@RequiredArgsConstructor
public class OrderDetailService implements IOrderDetailService{
    private final IOrderDetailRepository orderDetailRepository;
    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return this.orderDetailRepository.save(orderDetail);
    }
}
