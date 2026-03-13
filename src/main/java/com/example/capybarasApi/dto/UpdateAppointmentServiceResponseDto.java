package com.example.capybarasApi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.*;

@Data
public class UpdateAppointmentServiceResponseDto {
    @NotNull
    private Long appointmentId;

    @NotEmpty
    private List<@NotNull Long> serviceIds;
}
