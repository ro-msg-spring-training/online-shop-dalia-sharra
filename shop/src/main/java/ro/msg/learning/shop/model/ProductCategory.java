package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCTCATEGORY")
public class ProductCategory extends BaseEntity<Integer> {
    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
