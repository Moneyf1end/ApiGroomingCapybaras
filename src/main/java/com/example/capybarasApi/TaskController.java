package com.example.capybarasApi;

import com.example.capybarasApi.dto.UpdateAppointmentServiceRequestDto;
import com.example.capybarasApi.dto.UpdateAppointmentServiceResponseDto;
import com.example.capybarasApi.dto.UpdateOwnerByCapybaraIdRequestDto;
import com.example.capybarasApi.dto.UpdatedOwnerByCapybaraIdResponseDto;
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

    // GET METHODS --------------------------------------------------------------------------------------------
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

    // PUT(PATCH) METHODS -------------------------------------------------------------------------------------
    @PutMapping("/updateOwner/{id}")
    public Owner updateOwnerById(@PathVariable @Min(0) Long id, @RequestBody @Validated Owner owner) {
        return taskService.updateOwnerById(id, owner);
    }

    @PutMapping("/updateCapybara/{id}")
    public Capybara updateCapybaraById(@PathVariable @Min(0) Long id, @RequestBody @Validated Capybara capybara) {
        return taskService.updateCapybaraById(id, capybara);
    }

    @PatchMapping("/capybaras/{capybaraId}")
    public UpdatedOwnerByCapybaraIdResponseDto changeOwnerByCapybaraId(@PathVariable @Min(0) Long capybaraId, @RequestBody @Validated UpdateOwnerByCapybaraIdRequestDto updateOwnerByCapybaraIdDto) {
        return taskService.changeOwnerByCapybaraId(capybaraId, updateOwnerByCapybaraIdDto);
    }

    @PutMapping("/updateGroomer/{id}")
    public Groomer updateGroomerById(@PathVariable @Min(0) Long id, @RequestBody @Validated Groomer groomer) {
        return taskService.updateGroomerById(id, groomer);
    }

    @PutMapping("/updateTypeOfService/{id}")
    public TypeOfService updateTypeOfServiceById(@PathVariable @Min(0) Long id, @RequestBody @Validated TypeOfService typeOfService) {
        return taskService.updateTypeOfServiceById(id, typeOfService);
    }

    @PutMapping("/updateAppointment/{id}")
    public Appointment updateAppointment(@PathVariable @Min(0) Long id, @RequestBody @Validated Appointment appointment) {
        return taskService.updateAppointment(id, appointment);
    }

    @PutMapping("/appointments/{id}/services")
    public UpdateAppointmentServiceResponseDto updateAppointmentService(@PathVariable @Min(0) Long id, @RequestBody @Validated UpdateAppointmentServiceRequestDto serviceRequestDto) {
        return taskService.updateAppointmentService(id, serviceRequestDto);
    }
}
