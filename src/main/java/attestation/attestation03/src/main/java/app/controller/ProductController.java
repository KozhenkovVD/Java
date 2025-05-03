package app.controller;
import app.dto.ProductDto;
import app.dto.ProductDtoV2;
import app.services.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }


    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    public ProductDto patch(@PathVariable Long id, @RequestBody ProductDto productDto) throws IOException {
        return productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }

}
