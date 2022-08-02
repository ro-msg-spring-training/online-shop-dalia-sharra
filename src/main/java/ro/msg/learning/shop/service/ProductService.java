package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.exception.ProductException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductCategoryRepository;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.ISupplierRepository;
import ro.msg.learning.shop.utils.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Autowired
    private ISupplierRepository supplierRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().
                stream()
                .map(mapper::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) throws ProductException {
        if(!this.productCategoryRepository.existsById(productDto.getCategory().getId()))
        {
            throw new ProductException("The given product category does not exist!");
        }

        if(!this.supplierRepository.existsById(productDto.getSupplier().getId()))
        {
            throw new ProductException("The given supplier does not exist!");
        }
        Product product = mapper.dtoToProduct(productDto);
        return mapper.productToDto(this.productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) throws ProductException {
        if(this.productRepository.existsById(productDto.getId()))
        {
            this.productRepository.findById(productDto.getId())
                    .ifPresent(prod -> {
                        prod.setName(productDto.getName());
                        prod.setCategory(mapper.dtoToProductCategory(productDto.getCategory()));
                        prod.setDescription(productDto.getDescription());
                        prod.setImageUrl(productDto.getImageUrl());
                        prod.setPrice(productDto.getPrice());
                        prod.setWeight(productDto.getWeight());
                        prod.setSupplier(mapper.dtoToSupplier(productDto.getSupplier()));
                        this.productRepository.save(prod);
                    });
            return productDto;

        }
        else
        {
            throw new ProductException("Product does not exist!");
        }
    }

    @Override
    public void deleteProduct(Integer id) throws ProductException {
        if(this.productRepository.existsById(id))
        {
            this.productRepository.deleteById(id);
        }
        else
        {
            throw new ProductException("Product does not exist!");
        }
    }

    @Override
    public ProductDto getProductById(Integer id) throws ProductException {
        Optional<ProductDto> product = this.productRepository.findById(id).map(mapper::productToDto);
        if(product.isPresent())
        {
            return product.get();
        }
        else{
            throw new ProductException("Product with given id does not exist!");
        }

    }
}
