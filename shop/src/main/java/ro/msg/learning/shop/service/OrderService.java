package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.IOrderDetailRepository;
import ro.msg.learning.shop.repository.IOrderRepository;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.strategy.StrategyConfiguration;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IStockRepository stockRepository;

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Autowired
    StrategyConfiguration strategy;

    @Override
    public Order createOrder(Order order, List<OrderProduct> products) throws OrderException {
        List<OrderDetail> orderDetails = new ArrayList<>();
        products.forEach(product -> orderDetails.add(new OrderDetail(new OrderDetailId(order.getId(), product.getProductId()), order, productRepository.findById(product.getProductId()).get(), product.getQuantity())));
        try {
            List<LocationProductQuantity> result = strategy.getStrategy().executeStrategy(orderDetails);
            result.forEach(object -> {
                Stock stockProduct = stockRepository.findByStockProductAndStockLocation(object.getProduct(), object.getLocation());
                stockProduct.setQuantity(stockProduct.getQuantity() - object.getQuantity());
            });
            this.orderRepository.save(order);
            orderDetails.forEach(orderDetail -> {
                orderDetail.getOrderDetailId().setOrderId(order.getId());
                this.orderDetailRepository.save(orderDetail);
            });
            return order;

        }catch (OrderException e)
        {
            throw new OrderException(e.getMessage());
        }
    }
}
