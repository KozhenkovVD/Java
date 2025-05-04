package app.services.data;


import app.dto.CustomerDto;
import app.dto.ProductDto;
import app.model.Customer;
import app.model.Product;
import app.model.ProductType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public interface CustomerTestData {

    CustomerDto CUSTOMER_DTO_1 = new CustomerDto(1L, "login1", "password1", "customer1", "email1", CartTestData.CART_PRODUCT_DTO_LIST);
    CustomerDto CUSTOMER_DTO_2 = new CustomerDto(2L, "login2", "password2", "customer1", "email1", CartTestData.CART_PRODUCT_DTO_LIST);
    List<CustomerDto> CUSTOMER_DTO_LIST = Arrays.asList(CUSTOMER_DTO_1, CUSTOMER_DTO_2);

    Customer CUSTOMER_1 = new Customer("login1", "password1", "customer1", "email1", CartTestData.CART_PRODUCT_LIST);
    Customer CUSTOMER_2 = new Customer("login2", "password2", "customer2", "email2", CartTestData.CART_PRODUCT_LIST);
    List<Customer> CUSTOMER_LIST = Arrays.asList(CUSTOMER_1, CUSTOMER_2);

    CustomerDto CUSTOMER_DTO_1_UPDATE = new CustomerDto(1L, "login1", "password1", "customer199", "email1", CartTestData.CART_PRODUCT_DTO_LIST);
    Customer CUSTOMER_1_UPDATE = new Customer("login1", "password1", "customer199", "email1", CartTestData.CART_PRODUCT_LIST);

}
