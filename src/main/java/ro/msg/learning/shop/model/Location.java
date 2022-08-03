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

    @Column(name = "ADDRESS_COUNTRY")
    private String addressCountry;

    @Column(name = "ADDRESS_CITY")
    private String addressCity;

    @Column(name = "ADDRESS_COUNTY")
    private String addressCounty;

    @Column(name = "ADDRESS_STREET_ADDRESS")
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
