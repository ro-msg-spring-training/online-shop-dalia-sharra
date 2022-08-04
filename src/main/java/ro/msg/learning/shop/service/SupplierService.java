package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.ISupplierRepository;

@Service
@RequiredArgsConstructor
public class SupplierService implements ISupplierService{
    private final ISupplierRepository supplierRepository;
    @Override
    public boolean existsById(Integer id) {
        return this.supplierRepository.existsById(id);
    }
}
