package app.dto;

import app.model.CartProduct;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link CartProduct}
 */
@Value
@Builder
public class CartProductDtoCreate {
    Long customerId;
    Long productId;
    Integer quantity;




}