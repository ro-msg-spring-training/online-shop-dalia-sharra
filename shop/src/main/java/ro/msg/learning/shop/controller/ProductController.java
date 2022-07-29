package ro.msg.learning.shop.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.exception.ProductException;
import ro.msg.learning.shop.service.IProductService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    @ResponseBody
    public List<ProductDto> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id)
    {
        try
        {
            ProductDto productDto = productService.getProductById(id);
            return ResponseEntity.status(HttpStatus.OK).body(productDto);
        }catch (ProductException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody ProductDto product, HttpServletResponse response)
    {
        try {
            return productService.saveProduct(product);
        }catch (ProductException e)
        {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return null;
        }
    }

    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto product)
    {
        try
        {
            productService.updateProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully!");
        }catch (ProductException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id)
    {
        try{
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully!");
        }catch(ProductException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
