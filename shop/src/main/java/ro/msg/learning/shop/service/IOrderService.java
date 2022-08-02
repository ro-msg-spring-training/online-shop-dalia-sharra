package ro.msg.learning.shop.service;

import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.model.OrderProduct;

import java.util.List;

public interface IOrderService {
    Order createOrder(Order order, List<OrderProduct> products) throws OrderException;

}
