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
@Table(name = "ORDERT")
public class Order extends BaseEntity<Integer>{

    @ManyToOne
    @JoinColumn(name = "SHIPPEDFROM")
    @ToString.Exclude
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "CUSTOMERID")
    @ToString.Exclude
    private Customer customer;

    @Column(name = "CREATEDAT")
    private LocalDateTime createdAt;

    @Column(name = "ADDRESSCOUNTRY")
    private String addressCountry;

    @Column(name = "ADDRESSCITY")
    private String addressCity;

    @Column(name = "ADDRESSCOUNTY")
    private String addressCounty;

    @Column(name = "ADDRESSSTREETADDRESS")
    private String addressStreetAddress;

    @ToString.Exclude
    @OneToMany(mappedBy = "orderDetailOrder", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    public Order(LocalDateTime createdAt, String addressCountry, String addressCity, String addressCounty, String addressStreetAddress) {
        this.createdAt = createdAt;
        this.addressCountry = addressCountry;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressStreetAddress = addressStreetAddress;
    }
}
