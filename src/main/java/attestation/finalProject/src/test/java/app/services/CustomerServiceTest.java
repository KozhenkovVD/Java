package app.services;


import app.dto.CustomerDto;
import app.exception.NotFoundException;
import app.mapper.CustomerMapper;
import app.model.Customer;
import app.repository.CustomerRepository;
import app.services.data.CustomerTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {CustomerService.class})
class CustomerServiceTest {
    @MockitoBean
    private CustomerMapper customerMapper;
    @MockitoBean
    private CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Test
    void getAll() {
        Mockito.when(customerRepository.findAll()).thenReturn(CustomerTestData.CUSTOMER_LIST);
        Mockito.when(customerMapper.toDtoList(CustomerTestData.CUSTOMER_LIST)).thenReturn(CustomerTestData.CUSTOMER_DTO_LIST);
        List<CustomerDto> result = customerService.getAll();
        assertEquals(CustomerTestData.CUSTOMER_DTO_LIST, result);

    }

    @Test
    void getOne() {
        Customer customer = CustomerTestData.CUSTOMER_1;
        customer.setId(1L);
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(customerMapper.toDto(customer)).thenReturn(CustomerTestData.CUSTOMER_DTO_1);
        CustomerDto result = customerService.getOne(1L);
        assertEquals(CustomerTestData.CUSTOMER_DTO_1, result);
        assertNotEquals(CustomerTestData.CUSTOMER_DTO_2, result);
    }
    @Test
    void getOneException() throws NotFoundException {
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> customerService.getOne(1L));
        assertEquals(exception.getMessage(), "Покупатель с id `1` не найден");


    }
    @Test
    void changePassword() {
        Customer customer = CustomerTestData.CUSTOMER_1;
        customer.setId(1L);
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        String result = customerService.changePassword(1L, "newPassword");
        assertEquals("Пароль изменен", result);
    }

    @Test
    void changePasswordException() throws NotFoundException  {
        Customer customer = CustomerTestData.CUSTOMER_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> customerService.changePassword(1L, "newPassword"));
        assertEquals(exception.getMessage(), "Покупатель с id `1` не найден");
    }


    @Test
    void getCustomerByLogin() {
        Customer customer = CustomerTestData.CUSTOMER_1;
        customer.setId(1L);
        Mockito.when(customerRepository.findCustomerByLogin("login1")).thenReturn(customer);
        Mockito.when(customerMapper.toDto(customer)).thenReturn(CustomerTestData.CUSTOMER_DTO_1);
        CustomerDto result = customerService.getCustomerByLogin("login1");
        assertEquals(CustomerTestData.CUSTOMER_DTO_1, result);
    }

    @Test
    void getCustomerByEmail() {
        Customer customer = CustomerTestData.CUSTOMER_1;
        customer.setId(1L);
        Mockito.when(customerRepository.findCustomerByEmail("email1")).thenReturn(customer);
        Mockito.when(customerMapper.toDto(customer)).thenReturn(CustomerTestData.CUSTOMER_DTO_1);
        CustomerDto result = customerService.getCustomerByEmail("email1");
        assertEquals(CustomerTestData.CUSTOMER_DTO_1, result);
    }

    @Test
    void create() {
        Mockito.when(customerMapper.toEntity(CustomerTestData.CUSTOMER_DTO_1)).thenReturn(CustomerTestData.CUSTOMER_1);
        Mockito.when(customerRepository.save(CustomerTestData.CUSTOMER_1)).thenReturn(CustomerTestData.CUSTOMER_1);
        Mockito.when(customerMapper.toDto(CustomerTestData.CUSTOMER_1)).thenReturn(CustomerTestData.CUSTOMER_DTO_1);
        CustomerDto result = customerService.create(CustomerTestData.CUSTOMER_DTO_1);
        assertEquals(CustomerTestData.CUSTOMER_DTO_1, result);
    }

    @Test
    void update() throws NotFoundException {
        Customer customer = CustomerTestData.CUSTOMER_1;
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(customerMapper.toDto(customer)).thenReturn(CustomerTestData.CUSTOMER_DTO_1);
        Mockito.when(customerRepository.save(customer)).thenReturn(CustomerTestData.CUSTOMER_1_UPDATE);
        Mockito.when(customerMapper.toDto(CustomerTestData.CUSTOMER_1_UPDATE)).thenReturn(CustomerTestData.CUSTOMER_DTO_1_UPDATE);
        CustomerDto result = customerService.update(1L, CustomerTestData.CUSTOMER_DTO_1_UPDATE);
        assertEquals(CustomerTestData.CUSTOMER_DTO_1_UPDATE.getName(), result.getName());
    }

    @Test
    void updateException() throws NotFoundException{
        Customer customer = CustomerTestData.CUSTOMER_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> customerService.update(1L, CustomerTestData.CUSTOMER_DTO_1_UPDATE));
        assertEquals(exception.getMessage(), "Покупатель с id `1` не найден");


    }

    @Test
    void delete() throws NotFoundException{
        Customer customer = CustomerTestData.CUSTOMER_1;
        customer.setId(1L);
        Customer customerDelete = customer;
        customerDelete.setDeleted(true);
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(customerRepository.save(customerDelete)).thenReturn(customerDelete);
        String result = customerService.delete(1L);
        assertEquals("Покупатель удален", result);
    }

    @Test
    void deleteException() throws NotFoundException{
        Customer customer = CustomerTestData.CUSTOMER_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> customerService.delete(customer.getId()));
        assertEquals(exception.getMessage(), "Покупатель с id `null` не найден");


    }
}