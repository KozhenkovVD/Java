package app.controller;

import app.dto.OrderDto;
import app.services.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Заказы", description = "Контроллер для работы с заказами")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Получение списка всех заказов")
    @GetMapping("/all")
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @Operation(summary = "Получение заказа по id")
    @GetMapping("/{id}")
    public OrderDto getOne(@PathVariable Long id) {
        return orderService.getOne(id);
    }

    @Operation(summary = "Добавлене заказа")
    @PostMapping
    public OrderDto create(@RequestBody OrderDto dto) {
        return orderService.create(dto);
    }

    @Operation(summary = "Изменение заказа")
    @PutMapping("/{id}")
    public OrderDto update(@PathVariable Long id, @RequestBody OrderDto orderDto) throws IOException {
        return orderService.update(id, orderDto); }

    @Operation(summary = "Удаление заказа")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return orderService.delete(id);
    }

}
