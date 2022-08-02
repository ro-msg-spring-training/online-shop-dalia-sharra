package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "PRODUCTCATEGORY")
public class ProductCategory extends BaseEntity<Integer> {
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> products;
}
