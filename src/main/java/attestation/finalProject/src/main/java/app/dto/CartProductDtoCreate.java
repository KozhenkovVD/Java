package app.dto;

import app.model.CartProduct;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class CartProductDtoCreate {
    @Schema(description = "Идентификатор покупателя")
    Long customerId;
    @Schema(description = "Идентификатор продукта")
    Long productId;
    @Schema(description = "Количество")
    Integer quantity;




}