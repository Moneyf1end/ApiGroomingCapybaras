package com.example.capybarasApi;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
@Slf4j
@Validated
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public TypeOfService getServiceById(@PathVariable @Min(0) Long id) {
        log.info("Getting service with id: {}", id);
        return taskService.getServiceById(id);
    }

    @GetMapping
    public Iterable<TypeOfService> getAllServices() {
        log.info("Getting all services");
        return taskService.getAllServices();
    }


}
