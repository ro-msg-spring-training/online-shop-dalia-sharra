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
public class Customer extends BaseEntity<Integer>{
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String emailAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
