package ro.msg.learning.shop.service;

import ro.msg.learning.shop.exception.ProductException;
import ro.msg.learning.shop.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product product) throws ProductException;

    void updateProduct(Product product) throws ProductException;

    void deleteProduct(Integer id) throws ProductException;

    Product getProductById(Integer id) throws ProductException;

}
