package com.example.capybarasApi;

import com.example.capybarasApi.dto.UpdateOwnerByCapybaraIdRequestDto;
import com.example.capybarasApi.dto.UpdatedOwnerByCapybaraIdResponseDto;
import com.example.capybarasApi.mapper.TaskMapper;
import com.example.capybarasApi.repository.CapybaraRepository;
import com.example.capybarasApi.repository.GroomerRepository;
import com.example.capybarasApi.repository.OwnerRepository;
import com.example.capybarasApi.repository.TypeOfServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final OwnerRepository ownerRepository;
    private final CapybaraRepository capybaraRepository;
    private final GroomerRepository groomerRepository;
    private final TypeOfServiceRepository typeOfServiceRepository;
    private final TaskMapper taskMapper;

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
        return taskMapper.responseDto(capybaraAfterSave);
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
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Groomer not found"));

        serviceById.setDescription(service.getDescription());
        serviceById.setDifficultyLevel(service.getDifficultyLevel());
        serviceById.setDurationMinutes(service.getDurationMinutes());
        serviceById.setPrice(service.getPrice());

        return typeOfServiceRepository.save(serviceById);
    }
}
