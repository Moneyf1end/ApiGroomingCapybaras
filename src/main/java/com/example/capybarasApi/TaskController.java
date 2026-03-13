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

    // SERVICES
    @GetMapping("/service")
    public Iterable<TypeOfService> getAllServices() {
        return taskService.getAllServices();
    }

    @GetMapping("/service/{id}")
    // GET METHODS --------------------------------------------------------------------------------------------
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
    // ---------------- POST ----------------
    @PostMapping("/owner")
    public Owner createOwner(@RequestBody @Validated Owner owner) {
        return taskService.createOwner(owner);
    }

    @PostMapping("/capybara")
    public Capybara createCapybara(@RequestBody @Validated Capybara capybara) {
        return taskService.createCapybara(capybara);
    }

    @PostMapping("/groomer")
    public Groomer createGroomer(@RequestBody @Validated Groomer groomer) {
        return taskService.createGroomer(groomer);
    }

    @PostMapping("/service")
    public TypeOfService createService(@RequestBody @Validated TypeOfService service) {
        return taskService.createService(service);
    }

    @PostMapping("/appointment")
    public Appointment createAppointment(@RequestBody @Validated Appointment appointment) {
        return taskService.createAppointment(appointment);
    }
}

