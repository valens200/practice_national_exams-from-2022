package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateProductDTO;
import com.templates.valens.v1.exceptions.ForbiddenException;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Product;
import com.templates.valens.v1.models.enums.EProductType;
import com.templates.valens.v1.repositories.IProductRepository;
import com.templates.valens.v1.services.IProductService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl implements IProductService {
    private  final IProductRepository productRepository;

    @Override
    public Product create(CreateProductDTO dto, EProductType productType){
        try {
            if(productRepository.existsByCode(dto.getCode())) throw new ForbiddenException("The product with the provided code is already registered, you cant create duplicates");
            product = new Product();
            product.setCode(dto.getCode());
            product.setName(dto.getName());
            product.setPrice(dto.getPrice());
            product.setInDate(dto.getInDate());
            product.setType(productType);
            return productRepository.save(product);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Product update(UUID productId, CreateProductDTO dto){
        try {
            product = this.getById(productId);
            product.setName(dto.getName());
            product.setCode(dto.getCode());
            product.setPrice(dto.getPrice());
            product.setInDate(dto.getInDate());
            return this.productRepository.save(product);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public List<Product> getAll(){
        try {
            return this.productRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public Page<Product> getAllPaginated(Pageable pageable){
        try {
            return this.productRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Product getById(UUID id){
        try {
            return productRepository.findById(id).orElseThrow(()->new NotFoundException("The product with the provided id is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}
