package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.model.composite.ids.OrderDetailId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {
    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @MapsId("orderId")
    private Order orderDetailOrder;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @MapsId("productId")
    private Product orderDetailProduct;

    private Integer quantity;
}
