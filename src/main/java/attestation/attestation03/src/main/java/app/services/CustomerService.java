package app.services;

import app.dto.CustomerDto;
import app.mapper.CustomerMapper;
import app.model.Customer;
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

    private final ObjectMapper objectMapper;

    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDtoList(customers);
    }

    public CustomerDto getOne(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toDto(customerOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public CustomerDto getCustomerByLogin(String login) {
        return customerMapper.toDto(customerRepository.findCustomerByLogin(login));
    }

    public CustomerDto getCustomerByEmail(String email) {
        return customerMapper.toDto(customerRepository.findCustomerByEmail(email));
    }

    public void changePassword(Long customerId, String password) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с id `%s` не найден".formatted(customerId)));
        customer.setPassword(password);
        customerRepository.save(customer);
    }

    public CustomerDto create(CustomerDto dto) {
        Customer customer = customerMapper.toEntity(dto);
        Customer resultCustomer = customerRepository.save(customer);
        return customerMapper.toDto(resultCustomer);
    }

    public CustomerDto patch(Long id, JsonNode patchNode) throws IOException {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        CustomerDto customerDto = customerMapper.toDto(customer);
        objectMapper.readerForUpdating(customerDto).readValue(patchNode);
        customerMapper.updateWithNull(customerDto, customer);

        Customer resultCustomer = customerRepository.save(customer);
        return customerMapper.toDto(resultCustomer);
    }

    public CustomerDto delete(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customerRepository.delete(customer);
        }
        return customerMapper.toDto(customer);
    }


}
