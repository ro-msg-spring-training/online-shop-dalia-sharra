package ro.msg.learning.shop.service;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;

public interface IStockService {

    Stock saveStock(Stock stock);
    Stock findByStockProductAndStockLocation(Product stockProduct, Location stockLocation);

}
