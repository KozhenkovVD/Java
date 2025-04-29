package app.controller;

import app.dto.OrderDto;
import app.services.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto getOne(@PathVariable Long id) {
        return orderService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<OrderDto> getMany(@RequestParam List<Long> ids) {
        return orderService.getMany(ids);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto dto) {
        return orderService.create(dto);
    }

    @PatchMapping("/{id}")
    public OrderDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return orderService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return orderService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public OrderDto delete(@PathVariable Long id) {
        return orderService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        orderService.deleteMany(ids);
    }
}
