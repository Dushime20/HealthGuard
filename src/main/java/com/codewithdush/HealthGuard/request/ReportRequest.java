package com.codewithdush.HealthGuard.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReportRequest {
    @NotBlank(message = "Report type is mandatory")
    private String reportType;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Status is mandatory")
    private String status;

    // Getters and Setters
}

