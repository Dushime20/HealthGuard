package com.codewithdush.HealthGuard.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EdResourceRequest {

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "contentType is required")
    private String contentType;

    @NotNull(message = "description is mandatory")
    private String description;

    @NotNull(message = "url is required")
    private String url;

    private LocalDateTime createdAt;
}
