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
    public List<ProductDtoV2> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<ProductDto> getMany(@RequestParam List<Long> ids) {
        return productService.getMany(ids);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @PatchMapping("/{id}")
    public ProductDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return productService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return productService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public ProductDto delete(@PathVariable Long id) {
        return productService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        productService.deleteMany(ids);
    }
}
