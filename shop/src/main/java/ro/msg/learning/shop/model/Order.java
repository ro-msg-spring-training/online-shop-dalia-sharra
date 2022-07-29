package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity<Integer>{
    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private Customer customer;

    private LocalDateTime createdAt;

    private String addressCountry;

    private String addressCity;

    private String addressCounty;

    private String addressStreetAddress;

    @OneToMany(mappedBy = "orderDetailOrder")
    private Set<OrderDetail> orderDetails;
}
