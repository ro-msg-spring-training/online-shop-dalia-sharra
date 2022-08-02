package ro.msg.learning.shop.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class OrderProduct {
    private Integer productId;
    private Integer quantity;
}
