package app.dto;

import app.services.ProductService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DTO for {@link app.model.CartProductList}
 */
@Value
@Builder
public class CartProductListDtoAdd {
    Long customerId;
    Long productId;
    Integer quantity;




}