package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.LocationProductQuantity;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SingleLocationStrategy implements Strategy{

    @Override
    public List<LocationProductQuantity> executeStrategy(List<OrderDetail> products) throws OrderException {
        Set<Location> validLocations = new HashSet<>();
        List<LocationProductQuantity> result = new ArrayList<>();
        products.forEach(orderDetail -> validLocations.addAll(orderDetail.getOrderDetailProduct().getStocks().stream().filter(stock -> stock.getQuantity() >= orderDetail.getQuantity()).map(Stock::getStockLocation).collect(Collectors.toSet())));

        if(!validLocations.isEmpty()) {
            Location bestLocation = validLocations.iterator().next();

            products.forEach(orderDetail -> result.add(new LocationProductQuantity(bestLocation, orderDetail.getOrderDetailProduct(), orderDetail.getQuantity())));
            return result;
        }
        else
            throw new OrderException("No location have enough stocks!");
    }
}
