package com.example.capybarasApi;

import com.example.capybarasApi.repository.TypeOfServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class TaskService {

        private final TypeOfServiceRepository typeOfServiceRepository;

        public Iterable<TypeOfService> getAllServices() {
            log.info("Fetching all services");
            return typeOfServiceRepository.findAll();
        }

        public TypeOfService getServiceById(Long id) {
            log.info("Fetching service by id: {}", id);
            return typeOfServiceRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Service not found"));
        }
    }

