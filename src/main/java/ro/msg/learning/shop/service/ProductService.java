package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.ProductException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final IProductRepository productRepository;

    private final IProductCategoryService productCategoryService;

    private final ISupplierService supplierService;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) throws ProductException {
        if(!this.productCategoryService.existsById(product.getCategory().getId()))
        {
            throw new ProductException("The given product category does not exist!");
        }

        if(!this.supplierService.existsById(product.getSupplier().getId()))
        {
            throw new ProductException("The given supplier does not exist!");
        }
        return this.productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) throws ProductException {
        if(this.productRepository.existsById(product.getId()))
        {
            this.productRepository.findById(product.getId())
                    .ifPresent(prod -> {
                        prod.setName(product.getName());
                        prod.setCategory(product.getCategory());
                        prod.setDescription(product.getDescription());
                        prod.setImageUrl(product.getImageUrl());
                        prod.setPrice(product.getPrice());
                        prod.setWeight(product.getWeight());
                        prod.setSupplier(product.getSupplier());
                        this.productRepository.save(prod);
                    });

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
    public Product getProductById(Integer id) throws ProductException {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isPresent())
        {
            return product.get();
        }
        else{
            throw new ProductException("Product with given id does not exist!");
        }

    }
}
