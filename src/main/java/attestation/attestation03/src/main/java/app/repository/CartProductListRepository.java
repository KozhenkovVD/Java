package app.repository;

import app.model.CartProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductListRepository extends JpaRepository<CartProductList, Long> {
}