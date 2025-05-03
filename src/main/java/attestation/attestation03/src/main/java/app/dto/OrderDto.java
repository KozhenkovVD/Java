package app.dto;

import app.model.OrderProduct;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Value
public class OrderDto {
    Long id;
    LocalDate orderDate;
    Long customerId;
    List<OrderProductDto> orderProductsList;


    @Value
    public static class OrderProductDto {
        Long productId;
        BigDecimal price;
        Integer quantity;
    }

}