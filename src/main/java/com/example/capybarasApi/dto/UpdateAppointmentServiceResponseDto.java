package com.example.capybarasApi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.*;

@Data
public class UpdateAppointmentServiceResponseDto {
    @NotNull
    private Long appointmentId;

    @NotNull
    private List<Long> serviceIds;
}
