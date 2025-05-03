package app.dto;

import app.model.ProductType;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

/**
 * DTO for {@link app.model.Product}
 */
@Value
public class ProductDto {
    Long id;
    ProductType type;
    String name;
    BigDecimal price;

}