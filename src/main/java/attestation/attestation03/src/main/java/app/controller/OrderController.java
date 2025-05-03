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

    @GetMapping("/all")
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto getOne(@PathVariable Long id) {
        return orderService.getOne(id);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto dto) {
        return orderService.create(dto);
    }

    @PutMapping("/{id}")
    public OrderDto update(@PathVariable Long id, @RequestBody OrderDto orderDto) throws IOException {
        return orderService.update(id, orderDto); }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return orderService.delete(id);
    }

}
