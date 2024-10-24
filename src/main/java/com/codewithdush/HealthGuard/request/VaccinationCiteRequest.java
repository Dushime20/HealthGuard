package com.codewithdush.HealthGuard.request;

import com.codewithdush.HealthGuard.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VaccinationCiteRequest {

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "name is required")
    private String citeDistrict;

    @NotNull(message = "name is required")
    private String citeSector;

    @NotNull(message = "name is required")
    private String citeCell;

    @NotNull(message = "name is required")
    private int availability;

    @NotNull(message = "name is required")
    private String contactInfo;

    @NotNull(message = "name is required")
    private LocalDateTime updatedAt;
}
