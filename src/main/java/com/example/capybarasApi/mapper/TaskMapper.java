package com.example.capybarasApi.mapper;

import com.example.capybarasApi.Appointment;
import com.example.capybarasApi.Capybara;
import com.example.capybarasApi.dto.UpdateAppointmentServiceResponseDto;
import com.example.capybarasApi.dto.UpdateOwnerByCapybaraIdRequestDto;
import com.example.capybarasApi.dto.UpdatedOwnerByCapybaraIdResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
//    public UpdateOwnerByCapybaraIdRequestDto capybaraResponseToDto(Capybara capybara) {
//        if (capybara == null) return null;
//
//    }

//    public Capybara toEntity(UpdateOwnerByCapybaraIdRequestDto update) {
//        if (update == null) return null;
//
//        Capybara capybara = new Capybara();
//        capybara.setOwner();
//    }

    public UpdatedOwnerByCapybaraIdResponseDto updatedOwnerByCapybaraIdResponseDto(Capybara capybara) {
        if (capybara == null) return null;

        UpdatedOwnerByCapybaraIdResponseDto responseDto = new UpdatedOwnerByCapybaraIdResponseDto();
        responseDto.setId(capybara.getId());
        responseDto.setOwnerId(capybara.getOwner().getId());

        return responseDto;
    }

    public UpdateAppointmentServiceResponseDto updateAppointmentServiceResponseDto(Appointment appointment) {
        if (appointment == null) return null;

        UpdateAppointmentServiceResponseDto responseDto = new UpdateAppointmentServiceResponseDto();

        List<Long> listAfterStream = appointment.getServices().stream()
                .map(elem -> elem.getId())
                .collect(Collectors.toList());

        responseDto.setAppointmentId(appointment.getId());
        responseDto.setServiceIds(listAfterStream);

        return responseDto;

    }
}
