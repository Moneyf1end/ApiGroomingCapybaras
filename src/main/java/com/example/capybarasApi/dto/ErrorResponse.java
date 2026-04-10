package com.example.capybarasApi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ErrorResponse {
    @NotBlank(message = "message cannot be empty")
    private String message;

    @NotBlank(message = "status code cannot be empty")
    private String statusCode;
}
