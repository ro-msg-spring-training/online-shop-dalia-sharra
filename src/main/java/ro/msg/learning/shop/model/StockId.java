package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class StockId implements Serializable {

    private Integer locationId;
    private Integer productId;

    public StockId(Integer locationId, Integer productId) {
        this.locationId = locationId;
        this.productId = productId;
    }
}
