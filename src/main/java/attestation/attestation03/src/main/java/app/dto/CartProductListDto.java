package app.dto;

import app.model.CartProductList;
import app.services.ProductService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DTO for {@link CartProductList}
 */
@Value
@Builder
public class CartProductListDto {
    Long customerId;
    ProductDto product;
    Integer quantity;


}