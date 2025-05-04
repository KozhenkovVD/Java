package app.services;

import app.dto.CustomerDto;
import app.dto.OrderDto;
import app.exception.NotFoundException;
import app.mapper.CustomerMapper;
import app.model.Customer;
import app.model.Order;
import app.repository.CustomerRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService{

    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDtoList(customers);
    }

    public CustomerDto getOne(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toDto(customerOptional.orElseThrow(() ->
                new NotFoundException("Покупатель с id `%s` не найден".formatted(id))));
    }


    public CustomerDto getCustomerByLogin(String login) {
        return customerMapper.toDto(customerRepository.findCustomerByLogin(login));
    }

    public CustomerDto getCustomerByEmail(String email) {
        return customerMapper.toDto(customerRepository.findCustomerByEmail(email));
    }

    public String changePassword(Long customerId, String password) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new NotFoundException("Покупатель с id `%s` не найден".formatted(customerId)));
        customer.setPassword(password);
        customerRepository.save(customer);
        return "Пароль изменен";
    }

    public CustomerDto create(CustomerDto dto) {
        Customer customer = customerMapper.toEntity(dto);
        Customer resultCustomer = customerRepository.save(customer);
        return customerMapper.toDto(resultCustomer);
    }

    public CustomerDto update(Long id, CustomerDto customerDto) throws NotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Покупатель с id `%s` не найден".formatted(id)));
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        Customer resultOrder = customerRepository.save(customer);
        return customerMapper.toDto(resultOrder);
    }

    public String delete(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Покупатель с id `%s` не найден".formatted(id)));
        if (customer != null) {
            customer.setDeleted(true);
            customerRepository.save(customer);
        }
        return "Покупатель удален";
    }


}
