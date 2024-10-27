package com.codewithdush.HealthGuard.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SymptomRequest {

    @NotEmpty(message = "symptoms list cannot be empty")
    private List<String> symptoms;

    private LocalDateTime submittedAt;

    @NotBlank(message = "description is required")
    private String description;
}
