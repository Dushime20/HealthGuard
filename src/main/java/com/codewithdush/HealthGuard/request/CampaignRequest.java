package com.codewithdush.HealthGuard.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CampaignRequest {

    @NotBlank(message = "Title is mandatory")
    private   String title;

    @NotBlank(message = "Address is mandatory")
    private String address ;

    @NotBlank(message = "description is mandatory")
    private String description;

    @NotNull(message = "Start Date is mandatory")
    private LocalDateTime startDate;

    @NotNull(message = "End Date is mandatory")
    private LocalDateTime endDate;

    private LocalDateTime updatedAt;
}
