package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = "category")
public class Product extends BaseEntity<Integer>{
    private String name;

    private String description;

    private BigDecimal price;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "CATEGORYID")
    @ToString.Exclude
    private ProductCategory category;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "SUPPLIERID")
    private Supplier supplier;

    @Column(name = "IMAGEURL")
    private String imageUrl;

    @OneToMany(mappedBy = "stockProduct", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "orderDetailProduct", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<OrderDetail> orderDetails;
}
