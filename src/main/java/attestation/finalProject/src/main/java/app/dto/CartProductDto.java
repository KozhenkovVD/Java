package app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class CartProductDto {
    @Schema(description = "Идентификатор покупателя")
    Long customerId;
    @Schema(description = "Товар")
    ProductDto product;
    @Schema(description = "Количество")
    Integer quantity;
}