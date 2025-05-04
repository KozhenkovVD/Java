package app.controller;
import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.services.CartService;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/{customerId}/carts")
@Tag(name = "Корзина", description = "Контроллер для работы с корзинами товаров")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @Operation(summary = "Получение товаров в корзине")
    @GetMapping
    public List<CartProductDto> getByCustomerId(@PathVariable Long customerId) {
        return cartService.getByCustomerId(customerId);
    }

    @Operation(summary = "Получение товара в корзине по id")
    @GetMapping("/{id}")
    public CartProductDto getOne(@PathVariable Long id) {
        return cartService.getOne(id);
    }

    @Operation(summary = "Добавление товара в корзину")
    @PostMapping
    public CartProductDto create(@PathVariable Long customerId, @RequestBody CartProductDtoCreate dto) {
        return cartService.create(customerId, dto);
    }

    @Operation(summary = "Изменение товара в корзине")
    @PutMapping("/{id}")
    public CartProductDto patch(@PathVariable Long id, @RequestBody CartProductDto cartProductDto) throws IOException {
        return cartService.update(id, cartProductDto);
    }

    @Operation(summary = "Удаление товара из корзины")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return cartService.delete(id);
    }

}
