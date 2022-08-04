package ro.msg.learning.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.exception.OrderException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;
import ro.msg.learning.shop.strategy.SingleLocationStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LocationStrategyTest {

    private final List<OrderDetail> orderDetails = new ArrayList<>();

    @InjectMocks
    private MostAbundantStrategy mostAbundantStrategy;

    @InjectMocks
    private SingleLocationStrategy singleLocationStrategy;

    private Location location1, location2, location3;

    private Order order;

    private Product product1, product2, product3;

    @BeforeEach
    void setUp()
    {
        ProductCategory productCategory1 = ProductCategory.builder().name("Category1").description("Description1").build();

        Supplier supplier1 = Supplier.builder().name("Supplier1").build();

        product1 = Product.builder().name("Product1")
                .description("Description1")
                .price(new BigDecimal("120.3"))
                .weight(10d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl1")
                .build();
        product2 = Product.builder().name("Product2")
                .description("Description2")
                .price(new BigDecimal("512.9"))
                .weight(3d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl2")
                .build();
        product3 = Product.builder().name("Product3")
                .description("Description3")
                .price(new BigDecimal(100))
                .weight(5d)
                .category(productCategory1)
                .supplier(supplier1)
                .imageUrl("ImageUrl3")
                .build();

        location1 = Location.builder()
                .name("Location1")
                .addressCountry("Romania")
                .addressCity("Cluj-Napoca")
                .addressCounty("Cluj")
                .addressStreetAddress("Street Croitorilor 12")
                .build();
        location2 = Location.builder()
                .name("Location2")
                .addressCountry("Spain")
                .addressCity("Barcelona")
                .addressCounty("Barcelona")
                .addressStreetAddress("Street Hola 12")
                .build();
        location3 = Location.builder()
                .name("Location3")
                .addressCountry("Romania")
                .addressCity("Brasov")
                .addressCounty("Brasov")
                .addressStreetAddress("Strada Fagului 2")
                .build();

        Set<Stock> stockSet1 = new HashSet<>();

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

        stockSet1.add(stock1);
        stockSet1.add(stock2);
        stockSet1.add(stock3);

        product1.setStocks(stockSet1);

        Set<Stock> stockSet2 = new HashSet<>();

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

        stockSet2.add(stock4);
        stockSet2.add(stock5);
        stockSet2.add(stock6);

        product2.setStocks(stockSet2);

        Set<Stock> stockSet3 = new HashSet<>();

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

        stockSet3.add(stock7);
        stockSet3.add(stock8);
        stockSet3.add(stock9);

        product3.setStocks(stockSet3);

        order = Order.builder()
                .createdAt(LocalDateTime.of(2015,
                        Month.JULY, 29, 19, 30, 40))
                .addressCountry("Romania")
                .addressCounty("Cluj")
                .addressCity("Cluj-Napoca")
                .addressStreetAddress("Strada Parang 26")
                .build();
    }

    @Test
    void mostAbundantLocationStrategySuccess()
    {
        OrderDetail orderDetail1 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product1)
                .quantity(3)
                .build();
        OrderDetail orderDetail2 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product2)
                .quantity(5)
                .build();
        OrderDetail orderDetail3 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product3)
                .quantity(6)
                .build();

        this.orderDetails.add(orderDetail1);
        this.orderDetails.add(orderDetail2);
        this.orderDetails.add(orderDetail3);

        List<LocationProductQuantity> result = mostAbundantStrategy.executeStrategy(this.orderDetails);
        assertThat(result).isNotNull();
        assertEquals(result.get(0).getLocation(), location3);
        assertEquals(result.get(1).getLocation(), location3);
        assertEquals(result.get(2).getLocation(), location2);
    }

    @Test
    void mostAbundantLocationStrategyFailure()
    {
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
        OrderException orderException = assertThrows(OrderException.class,
                () -> mostAbundantStrategy.executeStrategy(this.orderDetails));

        assertEquals("Not enough stock!", orderException.getMessage());
    }

    @Test
    void singleLocationStrategySuccess()
    {
        OrderDetail orderDetail1 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product1)
                .quantity(15)
                .build();
        OrderDetail orderDetail2 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product2)
                .quantity(3)
                .build();
        OrderDetail orderDetail3 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product3)
                .quantity(2)
                .build();

        this.orderDetails.add(orderDetail1);
        this.orderDetails.add(orderDetail2);
        this.orderDetails.add(orderDetail3);

        List<LocationProductQuantity> result = singleLocationStrategy.executeStrategy(this.orderDetails);
        assertThat(result).isNotNull();
        assertEquals(result.get(0).getLocation(), location3);
    }

    @Test
    void singleLocationStrategyFailure()
    {
        OrderDetail orderDetail1 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product1)
                .quantity(15)
                .build();
        OrderDetail orderDetail2 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product2)
                .quantity(3)
                .build();
        OrderDetail orderDetail3 = OrderDetail.builder()
                .orderDetailOrder(order)
                .orderDetailProduct(product3)
                .quantity(6)
                .build();

        this.orderDetails.add(orderDetail1);
        this.orderDetails.add(orderDetail2);
        this.orderDetails.add(orderDetail3);

        OrderException orderException = assertThrows(OrderException.class,
                () -> singleLocationStrategy.executeStrategy(this.orderDetails));

        assertEquals("No location have enough stocks!", orderException.getMessage());
    }
}
