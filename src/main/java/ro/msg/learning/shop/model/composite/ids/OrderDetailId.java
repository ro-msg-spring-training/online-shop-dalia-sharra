package ro.msg.learning.shop.model.composite.ids;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailId implements Serializable {
    private Integer orderId;

    private Integer productId;


}
