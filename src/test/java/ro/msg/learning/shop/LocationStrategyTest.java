package ro.msg.learning.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationStrategyTest {

    private List<OrderDetail> orderDetails = new ArrayList<>();

    @Autowired
    private MostAbundantStrategy mostAbundantStrategy;

    @BeforeEach
    void setUp()
    {
        ProductCategory productCategory1 = ProductCategory.builder().name("Category1").description("Description1").build();

        Supplier supplier1 = Supplier.builder().name("Supplier1").build();

        Product product1 = Product.builder().name("Product1")
                .description("Description1")
                .price(new BigDecimal("120.3"))
                .weight(10d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl1")
                .build();
        Product product2 = Product.builder().name("Product2")
                .description("Description2")
                .price(new BigDecimal("512.9"))
                .weight(3d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl2")
                .build();
        Product product3 = Product.builder().name("Product3")
                .description("Description3")
                .price(new BigDecimal(100))
                .weight(5d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl3")
                .build();

        Location location1 = Location.builder()
                .name("Location1")
                .addressCountry("Romania")
                .addressCity("Cluj-Napoca")
                .addressCounty("Cluj")
                .addressStreetAddress("Street Croitorilor 12")
                .build();
        Location location2 = Location.builder()
                .name("Location2")
                .addressCountry("Spain")
                .addressCity("Barcelona")
                .addressCounty("Barcelona")
                .addressStreetAddress("Street Hola 12")
                .build();
        Location location3 = Location.builder()
                .name("Location3")
                .addressCountry("Romania")
                .addressCity("Brasov")
                .addressCounty("Brasov")
                .addressStreetAddress("Strada Fagului 2")
                .build();

        Stock stock1 = Stock.builder()
                .stockProduct(product1)
                .stockLocation(location1)
                .quantity(10)
                .build();
        Stock stock2 = Stock.builder()
                .stockProduct(product1)
                .stockLocation(location2)
                .quantity(3)
                .build();
        Stock stock3 = Stock.builder()
                .stockProduct(product1)
                .stockLocation(location3)
                .quantity(21)
                .build();
        Stock stock4 = Stock.builder()
                .stockProduct(product2)
                .stockLocation(location1)
                .quantity(5)
                .build();
        Stock stock5 = Stock.builder()
                .stockProduct(product2)
                .stockLocation(location2)
                .quantity(2)
                .build();
        Stock stock6 = Stock.builder()
                .stockProduct(product2)
                .stockLocation(location3)
                .quantity(7)
                .build();
        Stock stock7 = Stock.builder()
                .stockProduct(product3)
                .stockLocation(location1)
                .quantity(5)
                .build();
        Stock stock8 = Stock.builder()
                .stockProduct(product3)
                .stockLocation(location2)
                .quantity(10)
                .build();
        Stock stock9 = Stock.builder()
                .stockProduct(product3)
                .stockLocation(location3)
                .quantity(4)
                .build();

        Order order = Order.builder()
                .createdAt(LocalDateTime.of(2015,
                        Month.JULY, 29, 19, 30, 40))
                .addressCountry("Romania")
                .addressCounty("Cluj")
                .addressCity("Cluj-Napoca")
                .addressStreetAddress("Strada Parang 26")
                .build();

        OrderDetail orderDetail1 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product1)
                .quantity(3)
                .build();
        OrderDetail orderDetail2 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product2)
                .quantity(10)
                .build();
        OrderDetail orderDetail3 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product3)
                .quantity(6)
                .build();

        this.orderDetails.add(orderDetail1);
        this.orderDetails.add(orderDetail2);
        this.orderDetails.add(orderDetail3);
    }

    @Test
    void mostAbundantLocationStrategy()
    {
        List<LocationProductQuantity> result = mostAbundantStrategy.executeStrategy(this.orderDetails);
//        assertEquals(result.get(0).getLocation(), location3);
//        assertEquals(result.get(1).getLocation(), location);
//        assertEquals(result.get(2).getLocation(), location3);
    }
}
