package ro.msg.learning.shop.model;

import lombok.*;

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
    @JoinColumn(name = "PRODUCTID")
    @MapsId("productId")
    @ToString.Exclude
    private Product stockProduct;

    @ManyToOne
    @JoinColumn(name = "LOCATIONID")
    @MapsId("locationId")
    @ToString.Exclude
    private Location stockLocation;

    private Integer quantity;
}
