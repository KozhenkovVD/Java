package app.controller;
import app.dto.ProductDto;
import app.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Товары/Услуги", description = "Контроллер для работы с товарами и услугами")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Получение списка всех товаров/услуг")
    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @Operation(summary = "Получение товаров/услуг по id")
    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }

    @Operation(summary = "Добавлене товаров/услуг")
    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @Operation(summary = "Изменение товаров/услуг")
    @PutMapping("/{id}")
    public ProductDto patch(@PathVariable Long id, @RequestBody ProductDto productDto) throws IOException {
        return productService.update(id, productDto);
    }
    @Operation(summary = "Удаление товаров/услуг")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }

}
