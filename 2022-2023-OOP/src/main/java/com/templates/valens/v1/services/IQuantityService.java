package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreateQuantityDTO;
import com.templates.valens.v1.models.Quantity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IQuantityService {
    Quantity create(CreateQuantityDTO dto);

    Quantity update(UUID quantityId, CreateQuantityDTO dto);

    List<Quantity> getAll();

    Page<Quantity> getAllPaginated(Pageable pageable);

    List<Quantity> getAllByProduct(UUID productId);

    Page<Quantity> getAllByProductPaginated(UUID productId, Pageable pageable);

    Quantity getById(UUID Id);
}
