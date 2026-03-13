package com.example.capybarasApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOwnerByCapybaraIdRequestDto {
    @NotNull
    @JsonProperty("owner_id")
    private Long ownerId;
}
