package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {
    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne
    private Order orderDetailOrder;

    @ManyToOne
    private Product orderDetailProduct;

    private Integer quantity;
}
