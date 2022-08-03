package ro.msg.learning.shop.model.composite.ids;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class StockId implements Serializable {
    private Integer locationId;
    private Integer productId;
}
