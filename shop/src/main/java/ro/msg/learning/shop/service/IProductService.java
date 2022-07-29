package ro.msg.learning.shop.service;

import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.exception.ProductException;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();

    ProductDto saveProduct(ProductDto productDto) throws ProductException;

    ProductDto updateProduct(ProductDto productDto) throws ProductException;

    void deleteProduct(Integer id) throws ProductException;

    ProductDto getProductById(Integer id) throws ProductException;

}
