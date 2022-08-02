package ro.msg.learning.shop.utils;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.*;
import ro.msg.learning.shop.model.*;

@Component
public class Mapper {
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

    public SupplierDto supplierToDto(Supplier supplier) {
        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .build();
    }

    public Supplier dtoToSupplier(SupplierDto supplierDto) {
        Supplier newSupplier = Supplier.builder()
                .name(supplierDto.getName())
                .build();
        newSupplier.setId(supplierDto.getId());
        return newSupplier;
    }

    public ProductDto productToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .imageUrl(product.getImageUrl())
                .supplier(this.supplierToDto(product.getSupplier()))
                .category(this.productCategoryToDto(product.getCategory()))
                .build();
    }

    public Product dtoToProduct(ProductDto productDto) {
        Product newProduct = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .category(this.dtoToProductCategory(productDto.getCategory()))
                .supplier(this.dtoToSupplier(productDto.getSupplier()))
                .imageUrl(productDto.getImageUrl())
                .build();
        newProduct.setId(productDto.getId());
        return newProduct;
    }

    public Order dtoToOrder(OrderDto orderDto)
    {
        return Order.builder()
                .createdAt(orderDto.getTimestamp())
                .addressCountry(orderDto.getAddressCountry())
                .addressCity(orderDto.getAddressCity())
                .addressCounty(orderDto.getAddressCounty())
                .addressStreetAddress(orderDto.getAddressStreetAddress())
                .build();
    }
}
