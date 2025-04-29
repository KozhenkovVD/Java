package app.dto;

import jakarta.validation.constraints.Email;
import lombok.Value;

import java.util.List;

/**
 * DTO for {@link app.model.Customer}
 */
@Value
public class CustomerDto {
    String name;
    String phoneNumber;
    @Email
    String email;
    List<CartProductListDto> cartProducts;

    @Value
    public static class CartProductListDto {
        String name;
        Integer quantity;
    }

}