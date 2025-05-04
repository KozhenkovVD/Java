package app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Value
public class OrderDto {
    @Schema(description = "Идентификатор")
    Long id;
    @Schema(description = "Дата заказа")
    LocalDate orderDate;
    @Schema(description = "Идентификатор покуптеля")
    Long customerId;
    @Schema(description = "Товары в заказе")
    List<OrderProductDto> orderProductsList;


    @Value
    public static class OrderProductDto {
        @Schema(description = "Идентификатор товара")
        Long productId;
        @Schema(description = "Цена товара")
        BigDecimal price;
        @Schema(description = "Количество товара")
        Integer quantity;
    }

}