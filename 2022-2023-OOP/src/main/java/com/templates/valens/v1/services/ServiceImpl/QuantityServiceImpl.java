package com.templates.valens.v1.services.ServiceImpl;
import com.templates.valens.v1.dtos.requests.CreateQuantityDTO;
import com.templates.valens.v1.exceptions.ForbiddenException;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Quantity;
import com.templates.valens.v1.repositories.IQuantityRepository;
import com.templates.valens.v1.services.IProductService;
import com.templates.valens.v1.services.IQuantityService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuantityServiceImpl extends ServiceImpl implements IQuantityService {
    private final IQuantityRepository quantityRepository;
    private final IProductService productService;

    @Override
    public Quantity create(CreateQuantityDTO dto){
        try {
            product = productService.getById(dto.getProductId());
            if(quantityRepository.existsByProductAndQuantity(product,dto.getQuantity())) throw new ForbiddenException("The quantity with the same product and quantity is already registered");
            quantity = new Quantity(product,dto.getQuantity(),dto.getOperation(),dto.getDate());
            return this.quantityRepository.save(quantity);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }

    }

    @Override
    public Quantity update(UUID quantityId, CreateQuantityDTO dto){
        try {
            quantity = this.getById(quantityId);
            product = this.productService.getById(dto.getProductId());
            quantity.setQuantity(dto.getQuantity());
            quantity.setProduct(product);
            quantity.setDate(dto.getDate());
            quantity.setOperation(dto.getOperation());
            return this.quantityRepository.save(quantity);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public List<Quantity> getAll(){
        try {
            return this.quantityRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public Page<Quantity> getAllPaginated(Pageable pageable){
        try {
            return this.quantityRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }

    }

    @Override
    public List<Quantity> getAllByProduct(UUID productId){
        try {
            product = productService.getById(productId);
            return this.quantityRepository.findAllByProduct(product);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }

    }
    @Override
    public Page<Quantity> getAllByProductPaginated(UUID productId, Pageable pageable){
        try {
            product = productService.getById(productId);
            return this.quantityRepository.findAllByProduct(product,pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public  Quantity getById(UUID Id){
        try {
            return this.quantityRepository.findById(Id).orElseThrow(()->new NotFoundException("The quantity with the provided id is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}
