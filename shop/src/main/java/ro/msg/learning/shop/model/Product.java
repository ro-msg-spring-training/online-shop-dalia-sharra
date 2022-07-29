package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity<Integer>{
    private String name;

    private String description;

    private BigDecimal price;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "CATEGORYID")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "SUPPLIERID")
    private Supplier supplier;

    @Column(name = "IMAGEURL")
    private String imageUrl;

    @OneToMany(mappedBy = "stockProduct")
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "orderDetailProduct")
    private Set<OrderDetail> orderDetails;
}
