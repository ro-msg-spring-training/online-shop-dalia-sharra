package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TestService implements ITestService{
    private final ILocationRepository locationRepository;
    private final IProductRepository productRepository;
    private final IStockRepository stockRepository;
    private final IProductCategoryRepository productCategoryRepository;
    private final ISupplierRepository supplierRepository;

    @Override
    public void populate() {
        final ProductCategory productCategory1 = ProductCategory.builder().name("Category1").description("Description1").build();

        final Supplier supplier1 = Supplier.builder().name("Supplier1").build();

        final Product product1 = Product.builder().name("Product1")
                .description("Description1")
                .price(new BigDecimal("120.3"))
                .weight(10d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl1")
                .build();
        final Product product2 = Product.builder().name("Product2")
                .description("Description2")
                .price(new BigDecimal("512.9"))
                .weight(3d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl2")
                .build();
        final Product product3 = Product.builder().name("Product3")
                .description("Description3")
                .price(new BigDecimal(100))
                .weight(5d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl3")
                .build();

        final Location location1 = Location.builder()
                .name("Location1")
                .addressCountry("Romania")
                .addressCity("Cluj-Napoca")
                .addressCounty("Cluj")
                .addressStreetAddress("Street Croitorilor 12")
                .build();
        final Location location2 = Location.builder()
                .name("Location2")
                .addressCountry("Spain")
                .addressCity("Barcelona")
                .addressCounty("Barcelona")
                .addressStreetAddress("Street Hola 12")
                .build();
        final Location location3 = Location.builder()
                .name("Location3")
                .addressCountry("Romania")
                .addressCity("Brasov")
                .addressCounty("Brasov")
                .addressStreetAddress("Strada Fagului 2")
                .build();

        final Stock stock1 = Stock.builder()
                .stockProduct(product1)
                .stockLocation(location1)
                .quantity(10)
                .build();

        final Stock stock2 = Stock.builder()
                .stockProduct(product1)
                .stockLocation(location2)
                .quantity(3)
                .build();
        final Stock stock3 = Stock.builder()
                .stockProduct(product1)
                .stockLocation(location3)
                .quantity(21)
                .build();

        final Stock stock4 = Stock.builder()
                .stockProduct(product2)
                .stockLocation(location1)
                .quantity(5)
                .build();
        final Stock stock5 = Stock.builder()
                .stockProduct(product2)
                .stockLocation(location2)
                .quantity(2)
                .build();
        final Stock stock6 = Stock.builder()
                .stockProduct(product2)
                .stockLocation(location3)
                .quantity(7)
                .build();

        final Stock stock7 = Stock.builder()
                .stockProduct(product3)
                .stockLocation(location1)
                .quantity(5)
                .build();
        final Stock stock8 = Stock.builder()
                .stockProduct(product3)
                .stockLocation(location2)
                .quantity(10)
                .build();
        final Stock stock9 = Stock.builder()
                .stockProduct(product3)
                .stockLocation(location3)
                .quantity(4)
                .build();

        this.supplierRepository.save(supplier1);

        this.productCategoryRepository.save(productCategory1);

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);

        this.locationRepository.save(location1);
        this.locationRepository.save(location2);
        this.locationRepository.save(location3);

        this.stockRepository.save(stock1);
        this.stockRepository.save(stock2);
        this.stockRepository.save(stock3);
        this.stockRepository.save(stock4);
        this.stockRepository.save(stock5);
        this.stockRepository.save(stock6);
        this.stockRepository.save(stock7);
        this.stockRepository.save(stock8);
        this.stockRepository.save(stock9);

    }
    @Override
    public void clear() {
        this.stockRepository.deleteAll();
        this.locationRepository.deleteAll();
        this.productRepository.deleteAll();
        this.productCategoryRepository.deleteAll();
        this.supplierRepository.deleteAll();
    }
}
