package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.model.composite.ids.OrderDetailId;
import ro.msg.learning.shop.repository.IOrderRepository;
import ro.msg.learning.shop.strategy.StrategyConfiguration;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

    private final IProductService productService;

    private final IStockService stockService;

    private final IOrderRepository orderRepository;

    private final IOrderDetailService orderDetailService;

    private final StrategyConfiguration strategy;

    @Override
    public Order createOrder(Order order, List<OrderProduct> products) throws OrderException {
        List<OrderDetail> orderDetails = new ArrayList<>();
        products.forEach(product -> orderDetails.add(new OrderDetail(new OrderDetailId(order.getId(), product.getProductId()), order, productService.getProductById(product.getProductId()), product.getQuantity())));
        try {
            List<LocationProductQuantity> result = strategy.getStrategy().executeStrategy(orderDetails);
            result.forEach(object -> {
                Stock productStock = stockService.findByStockProductAndStockLocation(object.getProduct(), object.getLocation());
                productStock.setQuantity(productStock.getQuantity() - object.getQuantity());
            });
            this.orderRepository.save(order);
            orderDetails.forEach(orderDetail -> {
                orderDetail.getOrderDetailId().setOrderId(order.getId());
                this.orderDetailService.saveOrderDetail(orderDetail);
            });
            return order;

        }catch (OrderException e)
        {
            throw new OrderException(e.getMessage());
        }
    }
}
