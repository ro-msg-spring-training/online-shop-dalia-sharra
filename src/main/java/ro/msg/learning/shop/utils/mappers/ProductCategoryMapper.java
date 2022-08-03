package ro.msg.learning.shop.utils.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.model.ProductCategory;

@Component
public class ProductCategoryMapper {
    public ProductCategoryDto productCategoryToDto(ProductCategory productCategory) {
        return ProductCategoryDto.builder()
                .id(productCategory.getId())
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .build();
    }

    public ProductCategory dtoToProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory newProd = ProductCategory.builder()
                .name(productCategoryDto.getName())
                .description(productCategoryDto.getDescription())
                .build();
        newProd.setId(productCategoryDto.getId());
        return newProd;
    }
}
