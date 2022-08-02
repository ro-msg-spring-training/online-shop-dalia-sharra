package ro.msg.learning.shop.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private ProductCategoryDto category;
    private SupplierDto supplier;
    private String imageUrl;
}
