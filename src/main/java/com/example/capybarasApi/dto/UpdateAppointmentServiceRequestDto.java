package com.example.capybarasApi.dto;

import com.example.capybarasApi.TypeOfService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.*;

@Data
public class UpdateAppointmentServiceRequestDto {
    @JsonProperty("service_ids")
    private List<Long> serviceIds;
}
