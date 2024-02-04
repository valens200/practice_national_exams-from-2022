package com.templates.valens.v1.repositories;
import com.templates.valens.v1.models.Product;
import com.templates.valens.v1.models.Quantity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IQuantityRepository extends JpaRepository<Quantity, UUID> {
    boolean existsByProductAndQuantity(Product product, double quantity);
    List<Quantity> findAllByProduct(Product product);
    Page<Quantity> findAllByProduct(Product product, Pageable pageable);

}
