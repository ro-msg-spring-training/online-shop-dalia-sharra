package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false, exclude = "products")
public class Supplier extends BaseEntity<Integer>{
    private String name;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private Set<Product> products;
}
