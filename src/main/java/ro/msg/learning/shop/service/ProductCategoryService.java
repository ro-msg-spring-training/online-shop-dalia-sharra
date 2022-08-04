package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.IProductCategoryRepository;

@Service
@RequiredArgsConstructor
public class ProductCategoryService implements IProductCategoryService{
    private final IProductCategoryRepository productCategoryRepository;

    @Override
    public boolean existsById(Integer id) {
        return this.productCategoryRepository.existsById(id);
    }
}
