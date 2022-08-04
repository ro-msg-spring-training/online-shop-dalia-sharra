package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "ORDERS")
public class Order extends BaseEntity<Integer>{

    @ManyToOne
    @JoinColumn(name = "SHIPPED_FROM")
    @ToString.Exclude
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @ToString.Exclude
    private Customer customer;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "ADDRESS_COUNTRY")
    private String addressCountry;

    @Column(name = "ADDRESS_CITY")
    private String addressCity;

    @Column(name = "ADDRESS_COUNTY")
    private String addressCounty;

    @Column(name = "ADDRESS_STREET_ADDRESS")
    private String addressStreetAddress;

    @ToString.Exclude
    @OneToMany(mappedBy = "orderDetailOrder", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;


}
