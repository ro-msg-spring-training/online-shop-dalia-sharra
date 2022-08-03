package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.IStockRepository;

@Service
@RequiredArgsConstructor
public class StockService implements IStockService{
    private final IStockRepository stockRepository;

    @Override
    public Stock saveStock(Stock stock) {
        return this.stockRepository.save(stock);
    }

    @Override
    public Stock findByStockProductAndStockLocation(Product stockProduct, Location stockLocation) {
        return this.stockRepository.findByStockProductAndStockLocation(stockProduct, stockLocation);
    }
}
