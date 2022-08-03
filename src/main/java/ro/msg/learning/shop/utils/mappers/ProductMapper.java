package ro.msg.learning.shop.utils.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.Product;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ProductCategoryMapper productCategoryMapper;

    private final SupplierMapper supplierMapper;

    public ProductDto productToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .imageUrl(product.getImageUrl())
                .supplier(supplierMapper.supplierToDto(product.getSupplier()))
                .category(productCategoryMapper.productCategoryToDto(product.getCategory()))
                .build();
    }

    public Product dtoToProduct(ProductDto productDto) {
        Product newProduct = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .category(productCategoryMapper.dtoToProductCategory(productDto.getCategory()))
                .supplier(supplierMapper.dtoToSupplier(productDto.getSupplier()))
                .imageUrl(productDto.getImageUrl())
                .build();
        newProduct.setId(productDto.getId());
        return newProduct;
    }

}
