package com.example.capybarasApi.mapper;

import com.example.capybarasApi.Capybara;
import com.example.capybarasApi.dto.UpdateOwnerByCapybaraIdRequestDto;
import com.example.capybarasApi.dto.UpdatedOwnerByCapybaraIdResponseDto;
import org.springframework.stereotype.Component;

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

    public UpdatedOwnerByCapybaraIdResponseDto responseDto(Capybara capybara) {
        if (capybara == null) return null;

        UpdatedOwnerByCapybaraIdResponseDto responseDto = new UpdatedOwnerByCapybaraIdResponseDto();
        responseDto.setId(capybara.getId());
        responseDto.setOwnerId(capybara.getOwner().getId());

        return responseDto;

    }
}
