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
        return customers.stream()
                .map(customerMapper::toCustomerDto)
                .toList();
    }

    public CustomerDto getOne(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toCustomerDto(customerOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<CustomerDto> getMany(List<Long> ids) {
        List<Customer> customers = customerRepository.findAllById(ids);
        return customers.stream()
                .map(customerMapper::toCustomerDto)
                .toList();
    }

    public CustomerDto create(CustomerDto dto) {
        Customer customer = customerMapper.toEntity(dto);
        Customer resultCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDto(resultCustomer);
    }

    public CustomerDto patch(Long id, JsonNode patchNode) throws IOException {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        CustomerDto customerDto = customerMapper.toCustomerDto(customer);
        objectMapper.readerForUpdating(customerDto).readValue(patchNode);
        customerMapper.updateWithNull(customerDto, customer);

        Customer resultCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDto(resultCustomer);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<Customer> customers = customerRepository.findAllById(ids);

        for (Customer customer : customers) {
            CustomerDto customerDto = customerMapper.toCustomerDto(customer);
            objectMapper.readerForUpdating(customerDto).readValue(patchNode);
            customerMapper.updateWithNull(customerDto, customer);
        }

        List<Customer> resultCustomers = customerRepository.saveAll(customers);
        return resultCustomers.stream()
                .map(Customer::getId)
                .toList();
    }

    public CustomerDto delete(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customerRepository.delete(customer);
        }
        return customerMapper.toCustomerDto(customer);
    }

    public void deleteMany(List<Long> ids) {
        customerRepository.deleteAllById(ids);
    }
}
