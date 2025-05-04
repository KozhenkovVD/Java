package app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Value;

import java.util.List;


@Value
public class CustomerDto {
    @Schema(description = "Идентификатор покупателя")
    Long id;
    @Schema(description = "Логин покупателя")
    String login;
    @Schema(description = "Пароль покупателя")
    String password;
    @Schema(description = "Имя покупателя")
    String name;
    @Schema(description = "Emai покупателя")
    String email;
    @Schema(description = "Список продуктов в корзине покупателя")
    List<CartProductDto> cartProducts;
}