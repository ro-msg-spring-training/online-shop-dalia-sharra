package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class OrderDetailId implements Serializable {
    private Integer orderId;

    private Integer productId;

    public OrderDetailId(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
