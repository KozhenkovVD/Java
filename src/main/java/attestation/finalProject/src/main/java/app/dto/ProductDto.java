package app.dto;

import app.model.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductDto {
    @Schema(description = "Идентификатор")
    Long id;
    @Schema(description = "Тип продукта")
    ProductType type;
    @Schema(description = "Название продукта")
    String name;
    @Schema(description = "Цена")
    BigDecimal price;

}