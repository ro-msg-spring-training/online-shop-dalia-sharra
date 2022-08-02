package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.LocationProductQuantity;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MostAbundantStrategy implements Strategy{

    @Override
    public List<LocationProductQuantity> executeStrategy(List<OrderDetail> products) throws OrderException {
        List<LocationProductQuantity> result = new ArrayList<>();
        products.forEach(orderDetail -> {
            Optional<Stock> optionalStock = orderDetail.getOrderDetailProduct().getStocks().stream().filter(stock -> stock.getQuantity() >= orderDetail.getQuantity()).max(Comparator.comparing(Stock::getQuantity));
            if(optionalStock.isPresent()) {
                Stock greatestStock = optionalStock.get();
                result.add(new LocationProductQuantity(greatestStock.getStockLocation(), greatestStock.getStockProduct(), orderDetail.getQuantity()));
            }
            else {
                throw new OrderException("Not enough stock!");
            }
        });
        return result;
    }
}
