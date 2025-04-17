package app.controller;

import app.model.Customer;
import app.repository.CustomerRepository;
import app.repository.impl.CustomerRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @GetMapping("/customers")
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @GetMapping("/customers/{id}")
    public List<Customer>  getCustomerById(@PathVariable("id") Integer id) {
        return customerRepository.getById(id);
    }

//    @PostMapping("/books")
//    public List<Customer>  addBook(@RequestBody Book book) {
//        return customerRepository.addBook(book);
//    }
}

