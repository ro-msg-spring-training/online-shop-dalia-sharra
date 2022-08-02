package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "stocks")
public class Location extends BaseEntity<Integer>{
    private String name;

    @Column(name = "ADDRESSCOUNTRY")
    private String addressCountry;

    @Column(name = "ADDRESSCITY")
    private String addressCity;

    @Column(name = "ADDRESSCOUNTY")
    private String addressCounty;

    @Column(name = "ADDRESSSTREETADDRESS")
    private String addressStreetAddress;

    @ToString.Exclude
    @OneToMany(mappedBy = "shippedFrom", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @ToString.Exclude
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Set<Revenue> revenues;

    @ToString.Exclude
    @OneToMany(mappedBy = "stockLocation", fetch = FetchType.LAZY)
    private Set<Stock> stocks;
}
