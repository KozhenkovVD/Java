package repository;

import model.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    List<Customer> findById(Integer id);
    void deleteAll();
}
