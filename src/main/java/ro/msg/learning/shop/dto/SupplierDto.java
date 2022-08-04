package ro.msg.learning.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplierDto {
    private Integer id;
    private String name;
}
