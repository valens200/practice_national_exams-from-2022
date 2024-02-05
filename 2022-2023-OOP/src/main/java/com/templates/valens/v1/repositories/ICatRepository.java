package com.templates.valens.v1.repositories;
import com.templates.valens.v1.models.Cart;
import com.templates.valens.v1.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ICatRepository extends JpaRepository<Cart, UUID> {
    Cart findByCustomer(Customer customer);
}
