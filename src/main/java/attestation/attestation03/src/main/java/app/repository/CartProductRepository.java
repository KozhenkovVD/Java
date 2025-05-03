package app.repository;

import app.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    List<CartProduct> findByCustomerId(Long customerId);
}