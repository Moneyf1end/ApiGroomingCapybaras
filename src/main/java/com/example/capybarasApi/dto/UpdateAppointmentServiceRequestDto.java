package com.example.capybarasApi.dto;

import com.example.capybarasApi.TypeOfService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.*;

@Data
public class UpdateAppointmentServiceRequestDto {
    @JsonProperty("service_ids")
    @NotEmpty
    private List<@NotNull Long> serviceIds;
}
