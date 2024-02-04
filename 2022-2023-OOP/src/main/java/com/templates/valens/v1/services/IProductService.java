package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreateProductDTO;
import com.templates.valens.v1.models.Product;
import com.templates.valens.v1.models.enums.EProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    Product create(CreateProductDTO dto, EProductType productType);

    Product update(UUID productId, CreateProductDTO dto);

    List<Product> getAll();

    Page<Product> getAllPaginated(Pageable pageable);

    Product getById(UUID id);
}
