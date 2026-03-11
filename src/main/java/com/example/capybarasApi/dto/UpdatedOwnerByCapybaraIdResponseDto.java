package com.example.capybarasApi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatedOwnerByCapybaraIdResponseDto {
    @NotNull
    private Long id;

    @NotNull
    private Long ownerId;
}
