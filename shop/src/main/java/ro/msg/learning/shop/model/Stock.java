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
public class Stock implements Serializable {
    @EmbeddedId
    private StockId stockId;

    @ManyToOne
    private Product stockProduct;

    @ManyToOne
    private Location stockLocation;

    private Integer quantity;
}
