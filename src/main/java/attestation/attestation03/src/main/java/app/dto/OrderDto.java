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
    List<OrderProductListDto> orderProductsList;


    @Value
    public static class OrderProductListDto {
        Long productId;
        BigDecimal price;
        Integer quantity;
    }

}