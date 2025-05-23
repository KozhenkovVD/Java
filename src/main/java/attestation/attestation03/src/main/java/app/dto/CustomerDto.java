package app.dto;

import jakarta.validation.constraints.Email;
import lombok.Value;

import java.util.List;


@Value
public class CustomerDto {
    Long id;
    String login;
    String password;
    String name;
    @Email
    String email;
    List<CartProductDto> cartProducts;
}