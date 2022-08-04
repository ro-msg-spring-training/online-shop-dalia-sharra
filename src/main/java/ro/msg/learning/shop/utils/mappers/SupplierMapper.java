package ro.msg.learning.shop.utils.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.model.Supplier;

@Component
public class SupplierMapper {
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
}
