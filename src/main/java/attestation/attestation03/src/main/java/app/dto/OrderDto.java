package app.dto;

import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link app.model.Order}
 */
@Value
public class OrderDto {
    Long id;
    LocalDate orderDate;
    Long customerId;
    //LocalDateTime inDateTime;
    List<OrderProductListDto> orderProductsList;

    /**
     * DTO for {@link app.model.OrderProductList}
     */
    @Value
    public static class OrderProductListDto {
        Long productId;
        BigDecimal price;
        Integer quantity;
    }

}