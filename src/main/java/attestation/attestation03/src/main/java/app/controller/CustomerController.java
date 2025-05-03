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

    @PostMapping("/registration")
    public String create(@RequestBody CustomerDto customerDtoCreate) {
        if (customerService.getCustomerByLogin(customerDtoCreate.getLogin()) != null) {
            return "Пользователь с таким логином уже зарегистрирован.";
        }
        if (customerService.getCustomerByEmail(customerDtoCreate.getEmail()) != null) {
            return "Пользователь с таким email уже зарегистрирован.";
        }
        customerService.create(customerDtoCreate);
        return "Пользователь " + customerDtoCreate.getLogin() + " успешно зарегистрирован.";
    }

    @PostMapping("/{id}/change-password")
    public String changePassword(@PathVariable Long id,
                                 @RequestBody CustomerDto customerDto) {
        if (customerService.getOne(id).getPassword().equals(customerDto.getPassword())) {
            return "Пароль не должен совпадать с текущим паролем.";
        } else
            customerService.changePassword(id, customerDto.getPassword());
        return "Пароль успешно изменен.";
    }

    @PatchMapping("/{id}")
    public CustomerDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return customerService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public CustomerDto delete(@PathVariable Long id) {
        return customerService.delete(id);
    }


}
