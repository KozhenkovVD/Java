package app.repository;

import app.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    List<Customer> getById(Integer id);
    void deleteAll();
    void addCustomer(Customer customer);
}
