package app.repository;

import app.model.OrderProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductListRepository extends JpaRepository<OrderProductList, Long> {
}