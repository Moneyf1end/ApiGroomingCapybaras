package com.example.capybarasApi;

import com.example.capybarasApi.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TypeOfServiceRepository typeOfServiceRepository;
    private final CapybaraRepository capybaraRepository;
    private final GroomerRepository groomerRepository;
    private final OwnerRepository ownerRepository;
    private final AppointmentRepository appointmentRepository;

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
}