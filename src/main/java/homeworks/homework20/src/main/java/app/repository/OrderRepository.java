package app.repository;


import app.model.Order;

import java.util.List;


public interface OrderRepository {
    List<Order> getAll();
    List<Order> findById(Integer id);
    void deleteAll();
}

