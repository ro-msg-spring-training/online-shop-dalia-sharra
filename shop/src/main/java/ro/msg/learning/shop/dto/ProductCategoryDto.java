package ro.msg.learning.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryDto {
    private Integer id;
    private String name;
    private String description;
}
