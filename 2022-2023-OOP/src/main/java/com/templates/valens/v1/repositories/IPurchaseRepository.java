package com.templates.valens.v1.repositories;
import com.templates.valens.v1.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, UUID> {

}
