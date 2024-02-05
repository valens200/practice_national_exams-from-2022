package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreateCustomerDTO;
import com.templates.valens.v1.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {
    Customer create(CreateCustomerDTO dto);

    Customer update(UUID customerId, CreateCustomerDTO dto);

    List<Customer> getAll();

    Page<Customer> getAllPaginated(Pageable pageable);

    Customer getById(UUID customerId);
}
