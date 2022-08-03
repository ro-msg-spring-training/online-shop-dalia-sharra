package ro.msg.learning.shop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.service.IProductService;
import ro.msg.learning.shop.utils.mappers.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/products")
    @ResponseBody
    public List<ProductDto> getAllProducts()
    {
        return this.productService.getAllProducts().
                stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id)
    {
        ProductDto productDto = productMapper.productToDto(this.productService.getProductById(id));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.productMapper.productToDto(this.productService.saveProduct(this.productMapper.dtoToProduct(productDto))));
    }

    @PutMapping("/products")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto)
    {
        this.productService.updateProduct(this.productMapper.dtoToProduct(productDto));
        return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully!");
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully!");
    }
}
