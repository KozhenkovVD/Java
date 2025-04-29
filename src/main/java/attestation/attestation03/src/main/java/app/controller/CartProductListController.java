package app.controller;
import app.dto.CartProductListDto;
import app.dto.CartProductListDtoAdd;
import app.services.CartProductListService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cartProductLists")
@RequiredArgsConstructor
public class CartProductListController {

    private final CartProductListService cartProductListService;

    @GetMapping
    public List<CartProductListDto> getAll() {
        return cartProductListService.getAll();
    }

    @GetMapping("/{id}")
    public CartProductListDto getOne(@PathVariable Long id) {
        return cartProductListService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<CartProductListDto> getMany(@RequestParam List<Long> ids) {
        return cartProductListService.getMany(ids);
    }

    @PostMapping
    public CartProductListDto create(@RequestBody CartProductListDtoAdd dto) {
        return cartProductListService.create(dto);
    }

    @PatchMapping("/{id}")
    public CartProductListDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return cartProductListService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return cartProductListService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public CartProductListDto delete(@PathVariable Long id) {
        return cartProductListService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        cartProductListService.deleteMany(ids);
    }
}
