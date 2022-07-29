package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseEntity<Integer>{
    private String name;

    private String addressCountry;

    private String addressCity;

    private String addressCounty;

    private String addressStreetAddress;

    @OneToMany(mappedBy = "shippedFrom")
    private Set<Order> orders;

    @OneToMany(mappedBy = "location")
    private Set<Revenue> revenues;

    @OneToMany(mappedBy = "stockLocation")
    private Set<Stock> stocks;
}
