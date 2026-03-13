package com.example.capybarasApi;

import com.example.capybarasApi.dto.UpdateAppointmentServiceRequestDto;
import com.example.capybarasApi.dto.UpdateAppointmentServiceResponseDto;
import com.example.capybarasApi.dto.UpdateOwnerByCapybaraIdRequestDto;
import com.example.capybarasApi.dto.UpdatedOwnerByCapybaraIdResponseDto;
import com.example.capybarasApi.mapper.TaskMapper;
import com.example.capybarasApi.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final OwnerRepository ownerRepository;
    private final CapybaraRepository capybaraRepository;
    private final GroomerRepository groomerRepository;
    private final TypeOfServiceRepository typeOfServiceRepository;
    private final AppointmentRepository appointmentRepository;
    private final TaskMapper taskMapper;

    // SERVICES

    public Iterable<TypeOfService> getAllServices() {
        log.info("Fetching all services");
        return typeOfServiceRepository.findAll();
    }

    public TypeOfService getServiceById(Long id) {
        log.info("Fetching service by id: {}", id);
        return typeOfServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    //  CAPYBARAS

    public Iterable<Capybara> getAllCapybaras() {
        log.info("Fetching all capybaras");
        return capybaraRepository.findAll();
    }

    public Capybara getCapybaraById(Long id) {
        log.info("Fetching capybara by id: {}", id);
        return capybaraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Capybara not found"));
    }

    //  GROOMERS

    public Iterable<Groomer> getAllGroomers() {
        log.info("Fetching all groomers");
        return groomerRepository.findAll();
    }

    public Groomer getGroomerById(Long id) {
        log.info("Fetching groomer by id: {}", id);
        return groomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Groomer not found"));
    }

    //  OWNERS

    public Iterable<Owner> getAllOwners() {
        log.info("Fetching all owners");
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) {
        log.info("Fetching owner by id: {}", id);
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }
    //  APPOINTMENTS

    public Iterable<Appointment> getAllAppointments() {
        log.info("Fetching all appointments");
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        log.info("Fetching appointment by id: {}", id);
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }


    // put methods realization
    public Owner updateOwnerById(Long id, Owner owner) {
        Optional<Owner> ownerById = ownerRepository.findById(id);

        if (ownerById.isPresent()) {
            log.info(ownerById.get().toString());

            Owner getOwnerByIdFromOptional = ownerById.get();

            getOwnerByIdFromOptional.setEmail(owner.getEmail());
            getOwnerByIdFromOptional.setFullName(owner.getFullName());
            getOwnerByIdFromOptional.setPhone(owner.getPhone());

            Owner savedOwnerAfterUpdate = ownerRepository.save(getOwnerByIdFromOptional);
            return savedOwnerAfterUpdate;
        }
        log.error("Owner not found");
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Owner not found"
        );
    }

    public Capybara updateCapybaraById(Long id, Capybara capybara) {
        Optional<Capybara> capybaraById = capybaraRepository.findById(id);

        if (capybaraById.isPresent()) {
//            log.info(capybaraById.get().toString());

            Capybara getCapybaraByIdFromOptional = capybaraById.get();

            getCapybaraByIdFromOptional.setNickName(capybara.getNickName());
            getCapybaraByIdFromOptional.setWeightKg(capybara.getWeightKg());
            getCapybaraByIdFromOptional.setAssType(capybara.getAssType());
            getCapybaraByIdFromOptional.setMood(capybara.getMood());

            Capybara savedCapybaraAfterUpdate = capybaraRepository.save(getCapybaraByIdFromOptional);
            return savedCapybaraAfterUpdate;
        }
        log.error("Capybara not found");
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Capybara not found"
        );
    }

    public UpdatedOwnerByCapybaraIdResponseDto changeOwnerByCapybaraId(Long id, UpdateOwnerByCapybaraIdRequestDto updateOwnerByCapybaraIdDto) {
        Capybara capybara = capybaraRepository.findById(id)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Capybara not found"));

        Owner owner = ownerRepository.findById(updateOwnerByCapybaraIdDto.getOwnerId())
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));

        capybara.setOwner(owner);

        Capybara capybaraAfterSave = capybaraRepository.save(capybara);
        return taskMapper.updatedOwnerByCapybaraIdResponseDto(capybaraAfterSave);
    }

    public Groomer updateGroomerById(Long id, Groomer groomer) {
        Groomer groomerById = groomerRepository.findById(id)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Groomer not found"));

        groomerById.setExperience(groomer.getExperience());
        groomerById.setFullName(groomer.getFullName());
        groomerById.setGender(groomer.getGender());
        groomerById.setPhone(groomer.getPhone());

        return groomerRepository.save(groomerById);
    }

    // Need to test this on postman
    public TypeOfService updateTypeOfServiceById(Long id, TypeOfService service) {
        TypeOfService serviceById = typeOfServiceRepository.findById(id)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "TypeOfService not found"));

        serviceById.setDescription(service.getDescription());
        serviceById.setDifficultyLevel(service.getDifficultyLevel());
        serviceById.setDurationMinutes(service.getDurationMinutes());
        serviceById.setPrice(service.getPrice());

        return typeOfServiceRepository.save(serviceById);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment appointmentById = appointmentRepository.findById(id)
                .orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));

        appointmentById.setStartTime(appointment.getStartTime());
        appointmentById.setStatus(appointment.getStatus());
        return appointmentRepository.save(appointmentById);
    }

    public UpdateAppointmentServiceResponseDto updateAppointmentService(Long id, UpdateAppointmentServiceRequestDto serviceRequestDto) {
        Appointment appointmentByIdForService = appointmentRepository.findById(id)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));

        List<TypeOfService> listTypeOfServiceById = typeOfServiceRepository.findAllById(serviceRequestDto.getServiceIds());

        if (listTypeOfServiceById.size() != serviceRequestDto.getServiceIds().size()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found");

        appointmentByIdForService.setServices(listTypeOfServiceById);

        Appointment appointmentAfterSave = appointmentRepository.save(appointmentByIdForService);

        return taskMapper.updateAppointmentServiceResponseDto(appointmentAfterSave);
    }
}