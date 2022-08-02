package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "REVENUE")
public class Revenue extends BaseEntity<Integer>{
    @ManyToOne
    @JoinColumn(name = "LOCATIONID")
    @ToString.Exclude
    private Location location;
    private LocalDate date;
    private BigDecimal sum;
}
