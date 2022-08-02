package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.LocationProductQuantity;
import ro.msg.learning.shop.model.OrderDetail;

import java.util.List;

public interface Strategy {
    List<LocationProductQuantity> executeStrategy(List<OrderDetail> products) throws OrderException;
}
