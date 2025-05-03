package app.repository;

import app.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductListRepository extends JpaRepository<OrderProduct, Long> {
}