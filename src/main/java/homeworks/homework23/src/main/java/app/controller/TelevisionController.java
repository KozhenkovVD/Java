package app.controller;

import app.dto.TelevisionDto;

import app.services.TelevisionService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Контроллер для телевизоров", description = "Контроллер для управления телевизорами")
public class TelevisionController {

    private final TelevisionService televisionService;
@Autowired
public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("/televisions")
    public List<TelevisionDto> getAll() {
        return televisionService.getAll();
    }
    @PostMapping("/televisions")
    void addTelevision(@RequestBody TelevisionDto television) {
        televisionService.add(television);
    }
    @PutMapping("/televisions")
    void updateTelevision(@RequestBody TelevisionDto television) {
        televisionService.update(television);
    }

    @DeleteMapping("/televisions")
    void deleteTelevision(@RequestBody TelevisionDto television) {
        televisionService.delete(television);
    }


}

