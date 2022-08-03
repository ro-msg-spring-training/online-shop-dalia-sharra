package ro.msg.learning.shop.model;

import lombok.*;
import ro.msg.learning.shop.model.composite.ids.StockId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "stockProduct")
@Table(name = "STOCK")
public class Stock implements Serializable {
    @EmbeddedId
    private StockId stockId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @MapsId("productId")
    @ToString.Exclude
    private Product stockProduct;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    @MapsId("locationId")
    @ToString.Exclude
    private Location stockLocation;

    private Integer quantity;
}
