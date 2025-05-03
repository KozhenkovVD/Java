package app.controller;
import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.services.CartService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/{customerId}/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<CartProductDto> getByCustomerId(@PathVariable Long customerId) {
        return cartService.getByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    public CartProductDto getOne(@PathVariable Long id) {
        return cartService.getOne(id);
    }

    @PostMapping
    public CartProductDto create(@PathVariable Long customerId, @RequestBody CartProductDtoCreate dto) {
        return cartService.create(customerId, dto);
    }

    @PutMapping("/{id}")
    public CartProductDto patch(@PathVariable Long id, @RequestBody CartProductDto cartProductDto) throws IOException {
        return cartService.update(id, cartProductDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return cartService.delete(id);
    }

}
