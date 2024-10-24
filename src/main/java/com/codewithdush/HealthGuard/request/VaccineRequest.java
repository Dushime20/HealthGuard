package com.codewithdush.HealthGuard.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VaccineRequest {
    @NotNull(message = "vaccineName is mandatory")
   private String vaccineName;

    @NotNull(message = "doseReceived is mandatory")
   private int doseReceived;

    @NotNull(message = "status  is mandatory")
   private String status;

   @NotNull(message = "nextDueDate is mandatory")
   private LocalDateTime nextDueDate;

    @NotNull(message = "recipient name is required")
    private String recipientName;

    @NotNull(message = "recipient phone is required")
    private String recipientPhone;

    @NotNull(message = "recipient district is required")
    private String recipientDistrict;

    @NotNull(message = "recipient sector is required")
    private String recipientSector;

    @NotNull(message = "recipient village is required")
    private String recipientVillage;

    @NotNull(message = "recipient cell is required")
    private String recipientCell;

    @NotNull(message = "created date is required")
    private LocalDateTime createdAt = LocalDateTime.now();
}
