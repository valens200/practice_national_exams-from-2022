package com.templates.valens.v1.services;

import com.templates.valens.v1.models.Cart;

import java.util.List;
import java.util.UUID;

public interface ICatService {
    List<Cart> getAll();

    Cart getById(UUID id);

    Cart getByCustomer(UUID customerId);

    Cart addQuantity(UUID quantityId, UUID cartId);

    Cart removeQuantity(UUID quantityId, UUID cartId);
}
