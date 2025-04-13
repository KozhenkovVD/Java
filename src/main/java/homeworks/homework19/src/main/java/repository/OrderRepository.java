package repository;


import model.Order;

import java.util.List;


public interface OrderRepository {
    List<Order> findAll();
    List<Order> findById(Integer id);
    void deleteAll();
}

