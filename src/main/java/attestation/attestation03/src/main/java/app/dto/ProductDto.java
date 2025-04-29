package app.dto;

import app.model.ProductType;
import lombok.Value;

import java.math.BigDecimal;

/**
 * DTO for {@link app.model.Product}
 */
@Value
public class ProductDto {
    ProductType type;
    String name;
    BigDecimal price;
}