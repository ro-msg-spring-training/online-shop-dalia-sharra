package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "ORDERDETAIL")
public class OrderDetail implements Serializable {
    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne
    @JoinColumn(name = "ORDERID")
    @MapsId("orderId")
    private Order orderDetailOrder;

    @ManyToOne
    @JoinColumn(name = "PRODUCTID")
    @MapsId("productId")
    private Product orderDetailProduct;

    private Integer quantity;
}
