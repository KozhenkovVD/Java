package app.mapper;

import app.dto.CustomerDto;
import app.dto.ProductDto;
import app.model.Customer;
import app.model.Product;
import app.services.data.CustomerTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {CustomerMapperImpl.class})
class CustomerMapperTest {

@Autowired
private CustomerMapper customerMapper;


    @Test
    void toEntity() {
        Customer customerExpected = CustomerTestData.CUSTOMER_1;
        Customer customer = customerMapper.toEntity(CustomerTestData.CUSTOMER_DTO_1);
        assertEquals(customerExpected.getName(),customer.getName());
    }

    @Test
    void toDto() {
        CustomerDto customerDtoExpected = CustomerTestData.CUSTOMER_DTO_1;
        CustomerDto customerDto = customerMapper.toDto(CustomerTestData.CUSTOMER_1);
        assertEquals(customerDtoExpected.getName(),customerDto.getName());
    }

    @Test
    void toDtoList() {
        List<CustomerDto> customertDtoListExpected = CustomerTestData.CUSTOMER_DTO_LIST;
        List<CustomerDto>  customerDtoList = customerMapper.toDtoList(CustomerTestData.CUSTOMER_LIST);
        assertEquals(customertDtoListExpected.size(),customerDtoList.size());
    }
}