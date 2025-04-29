package app.controller;

import app.dto.CustomerDto;
import app.services.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getOne(@PathVariable Long id) {
        return customerService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<CustomerDto> getMany(@RequestParam List<Long> ids) {
        return customerService.getMany(ids);
    }

    @PostMapping
    public CustomerDto create(@RequestBody @Valid CustomerDto dto) {
        return customerService.create(dto);
    }

    @PatchMapping("/{id}")
    public CustomerDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return customerService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam @Valid List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return customerService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public CustomerDto delete(@PathVariable Long id) {
        return customerService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        customerService.deleteMany(ids);
    }
}
