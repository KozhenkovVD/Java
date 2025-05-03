package app.services.data;

import app.dto.CustomerDto;
import app.dto.OrderDto;
import app.model.Customer;
import app.model.Order;
import app.model.OrderProduct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface OrderTestData {

    OrderDto.OrderProductDto ORDER_PRODUCT_DTO_1 = new OrderDto.OrderProductDto(1L, BigDecimal.valueOf(100), 9);
    OrderDto.OrderProductDto ORDER_PRODUCT_DTO_2 = new OrderDto.OrderProductDto(2L, BigDecimal.valueOf(100), 9);
    List<OrderDto.OrderProductDto> ORDER_PRODUCT_DTO_LIST = Arrays.asList(ORDER_PRODUCT_DTO_1, ORDER_PRODUCT_DTO_2);

    OrderProduct ORDER_PRODUCT_1 = new OrderProduct(1L, 1L, BigDecimal.valueOf(100), 9);
    OrderProduct ORDER_PRODUCT_2 = new OrderProduct(1L, 2L, BigDecimal.valueOf(100), 9);
    List<OrderProduct> ORDER_PRODUCT_LIST = Arrays.asList(ORDER_PRODUCT_1, ORDER_PRODUCT_2);

    OrderDto ORDER_DTO_1 = new OrderDto(1L, LocalDate.now(), 1L, ORDER_PRODUCT_DTO_LIST);
    OrderDto ORDER_DTO_2 = new OrderDto(2L, LocalDate.now(), 2L, ORDER_PRODUCT_DTO_LIST);
    List<OrderDto> ORDER_DTO_LIST = Arrays.asList(ORDER_DTO_1, ORDER_DTO_2);
    OrderDto ORDER_DTO_1_UPDATE = new OrderDto(1L, LocalDate.now(), 1L, ORDER_PRODUCT_DTO_LIST);

    Order ORDER_1 = new Order(LocalDate.now(), 1L, ORDER_PRODUCT_LIST);
    Order ORDER_2 = new Order(LocalDate.now(), 2L, ORDER_PRODUCT_LIST);
    List<Order> ORDER_LIST = Arrays.asList(ORDER_1, ORDER_2);







}
