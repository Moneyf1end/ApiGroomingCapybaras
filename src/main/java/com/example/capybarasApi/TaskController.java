package com.example.capybarasApi;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@Validated
public class TaskController {

    private final TaskService taskService;

    // SERVICES
    @GetMapping("/service")
    public Iterable<TypeOfService> getAllServices() {
        return taskService.getAllServices();
    }

    @GetMapping("/service/{id}")
    public TypeOfService getServiceById(@PathVariable @Min(0) Long id) {
        return taskService.getServiceById(id);
    }

    // CAPYBARAS
    @GetMapping("/capybara")
    public Iterable<Capybara> getAllCapybaras() {
        return taskService.getAllCapybaras();
    }

    @GetMapping("/capybara/{id}")
    public Capybara getCapybaraById(@PathVariable @Min(0) Long id) {
        return taskService.getCapybaraById(id);
    }

    // GROOMERS
    @GetMapping("/groomer")
    public Iterable<Groomer> getAllGroomers() {
        return taskService.getAllGroomers();
    }

    @GetMapping("/groomer/{id}")
    public Groomer getGroomerById(@PathVariable @Min(0) Long id) {
        return taskService.getGroomerById(id);
    }

    //  OWNERS
    @GetMapping("/owner")
    public Iterable<Owner> getAllOwners() {
        return taskService.getAllOwners();
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(@PathVariable @Min(0) Long id) {
        return taskService.getOwnerById(id);
    }

    // APPOINTMENTS
    @GetMapping("/appointment")
    public Iterable<Appointment> getAllAppointments() {
        return taskService.getAllAppointments();
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointmentById(@PathVariable @Min(0) Long id) {
        return taskService.getAppointmentById(id);
    }
}