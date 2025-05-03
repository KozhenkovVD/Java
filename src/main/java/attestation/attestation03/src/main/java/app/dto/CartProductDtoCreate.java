package app.dto;

import app.model.CartProduct;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link CartProduct}
 */
@Value
public class CartProductDtoCreate {
    Long customerId;
    Long productId;
    Integer quantity;




}